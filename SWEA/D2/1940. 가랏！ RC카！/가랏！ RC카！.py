T = int(input())
for tc in range(1, T + 1):
    N = int(input())
    commands = []
    for _ in range(N):
        commands.append(list(map(int, input().split())))
    dp = [0] * (N + 1)
    for i in range(N):
        if commands[i][0] == 1:
            dp[i + 1] = dp[i] + commands[i][1]
        elif commands[i][0] == 2:
            dp[i + 1] = dp[i] - commands[i][1]
            if dp[i + 1] < 0:
                dp[i + 1] = 0
        else:
            dp[i + 1] = dp[i]
    print(f"#{tc} {sum(dp)}")