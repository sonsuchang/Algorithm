default_list = [1, 1, 1, 2, 2, 3, 4, 5, 7, 9]
output_list = []
T = int(input())
for _ in range(T):
    N = int(input())
    if len(default_list) < N:
        for _ in range(N):
            default_list.append(default_list[-2] + default_list[-3])
        output_list.append(default_list[N - 1])
    else:
        output_list.append(default_list[N - 1])
for i in output_list:
    print(i)