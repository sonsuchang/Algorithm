import sys

T = int(sys.stdin.readline())

def find_max(dp, N):
    for i in range(1, N):
        if i == 1:
            dp[0][i] += dp[1][i - 1]
            dp[1][i] += dp[0][i - 1]
        else:
            dp[0][i] = max(dp[0][i] + dp[1][i - 2], dp[0][i] + dp[1][i - 1])
            dp[1][i] = max(dp[1][i] + dp[0][i - 2], dp[1][i] + dp[0][i - 1])
    return max(dp[0][-1], dp[1][-1])

for _ in range(T):
    N = int(sys.stdin.readline())
    dp = []
    for _ in range(2):
        dp.append(list(map(int, sys.stdin.readline().split())))
    if N == 1:
        print(max(dp[0][0], dp[1][0]))
        continue
    print(find_max(dp, N))