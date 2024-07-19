import sys

N = int(sys.stdin.readline())
N_list = []
dp = [0] * N

for _ in range(N):
    N_list.append(int(sys.stdin.readline()))

dp[0] = N_list[0]

if N <= 2:
    print(sum(N_list))
else:
    dp[1] = N_list[0] + N_list[1]
    dp[2] = max(N_list[2] + N_list[1], N_list[2] + N_list[0], dp[1])
    for i in range(3, N):
        dp[i] = max(dp[i - 1], dp[i - 3] + N_list[i - 1] + N_list[i], dp[i - 2] + N_list[i])
    print(dp[N - 1])