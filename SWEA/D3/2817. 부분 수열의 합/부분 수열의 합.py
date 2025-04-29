T = int(input())
for test_case in range(1, T + 1):
    N, K = map(int, input().split())
    N_list = list(map(int, input().split()))
    dp = [[] for _ in range(N)]
    length = len(N_list)
    dp[0].append(N_list[0])
    for i in range(1, length):
        dp[i] += dp[i - 1]
        dp[i].append(N_list[i])
        for j in dp[i - 1]:
            dp[i].append(N_list[i] + j)
    answer = dp[-1].count(K)
    print(f"#{test_case} {answer}")