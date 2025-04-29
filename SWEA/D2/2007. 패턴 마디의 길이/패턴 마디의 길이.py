T = int(input())
for test_case in range(1, T + 1):
    input_str = list(input().rstrip())
    length = len(input_str)
    target = []
    target.append(input_str[0])
    for i in range(1, length):
        if target == input_str[i : i + len(target)]:
            break
        target.append(input_str[i])
    answer = len(target)
    print(f"#{test_case} {answer}")