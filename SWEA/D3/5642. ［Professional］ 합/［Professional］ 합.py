T = int(input())
for tc in range(1, T + 1):
    N = int(input())
    N_list = list(map(int, input().split()))
    dp = [0] * N
    dp[0] = N_list[0]
    for i in range(1, N):
        dp[i] = max(dp[i - 1] + N_list[i], N_list[i])
    print(f"#{tc} {max(dp)}")