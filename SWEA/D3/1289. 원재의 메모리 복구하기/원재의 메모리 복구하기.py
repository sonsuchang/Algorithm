T = int(input())
for test_case in range(1, T + 1):
    data = list(input().rstrip())
    length = len(data)
    init = ["0"] * length
    answer = 0
    idx = 0
    while idx < length:
        if data[idx] != init[idx]:
            for j in range(idx, length):
                init[j] = data[idx]
            answer += 1
        idx += 1
    print(f"#{test_case} {answer}")