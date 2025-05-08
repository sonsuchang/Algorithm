T = int(input())
for test_case in range(1, T + 1):
    N, K = map(int, input().split())
    N_list = [list(map(int, input().split())) for _ in range(N)]
    dp = [[0] * (K + 1) for _ in range(N + 1)]
    for i in range(1, N + 1):
        w = N_list[i - 1][0]
        v = N_list[i - 1][1]
        for j in range(K + 1):
            if j < w:
                dp[i][j] = dp[i - 1][j]
            else:
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - w] + v)
    print(f"#{test_case} {dp[N][K]}")