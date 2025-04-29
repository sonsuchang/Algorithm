T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    N_list = [[1]]
    for i in range(2, N + 1):
        temp = []
        temp.append(1)
        for j in range(1, i - 1):
            temp.append(N_list[i - 2][j - 1] + N_list[i - 2][j])
        temp.append(1)
        N_list.append(temp)
    print(f"#{test_case}")
    for i in N_list:
        print(*i)