T = int(input())
for tc in range(1, T + 1):
    N = int(input()) // 10
    dp = [1, 3]
    for i in range(N - 2):
        dp.append(dp[-1] + 2 * dp[-2])
    print(f"#{tc} {dp[-1]}")