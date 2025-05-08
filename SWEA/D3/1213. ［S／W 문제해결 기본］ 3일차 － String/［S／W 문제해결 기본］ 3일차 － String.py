T = 10
for test_case in range(1, T + 1):
    tc = int(input())
    target = input().rstrip()
    origin = input().rstrip()
    target_length = len(target)
    origin_length = len(origin)
    idx = 0
    answer = 0
    while idx < origin_length:
        if origin[idx] == target[0]:
            if origin[idx : idx + target_length] == target:
                answer += 1
                idx += target_length
            else:
                idx += 1
        else:
            idx += 1
    print(f"#{tc} {answer}")