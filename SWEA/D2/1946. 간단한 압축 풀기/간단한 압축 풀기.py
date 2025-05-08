T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    N_list = []
    for _ in range(N):
        alpha, cnt = input().split()
        N_list += [alpha] * int(cnt)
    answer = []
    idx, length = 0, len(N_list)
    temp = []
    while idx < length:
        if len(temp) == 10:
            answer.append(temp)
            temp = []
        temp.append(N_list[idx])
        idx += 1
    answer.append(temp)
    print(f"#{test_case}")
    for i in answer:
        print(''.join(i))