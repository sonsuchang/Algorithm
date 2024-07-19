import sys, math
R, G, B = 0, 1, 2

N = int(sys.stdin.readline())
cost = [[-1, -1, -1]]
for _ in range(N):
    cost.append(list(map(int, sys.stdin.readline().split())))

answer = math.inf
for color in [R,G,B]:
    dp = [[-1]*3 for _ in range(N+1)]

    dp[1] = [math.inf, math.inf, math.inf]
    dp[1][color] = cost[1][color]

    for i in range(2, N+1):
        dp[i][R] = min(dp[i-1][G], dp[i-1][B]) + cost[i][R]
        dp[i][G] = min(dp[i-1][R], dp[i-1][B]) + cost[i][G]
        dp[i][B] = min(dp[i-1][R], dp[i-1][G]) + cost[i][B]
    dp[N][color] = math.inf
    answer = min(answer, min(dp[N]))
print(answer)