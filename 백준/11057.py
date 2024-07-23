import sys

N = int(sys.stdin.readline())

if N == 1:
    print(10)
elif N == 2:
    print(55)
else:
    N_list = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
    for _ in range(N - 2):
        N_list.append(sum(N_list))
        for i in range(9):
            N_list.append(N_list[-1] - N_list.pop(0))
        N_list.pop(0)
    print(sum(N_list) % 10007)