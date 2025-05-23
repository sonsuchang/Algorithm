T = int(input())
for tc in range(1, T + 1):
    N = int(input())
    N_list = list(map(int, input().split()))
    dp = [float('inf')] * 7
    for i in range(7):
        temp = N
        idx = i
        cnt = 0
        while temp > 0:
            if N_list[idx] == 1:
                temp -= 1
            cnt += 1
            idx += 1
            if idx == 7:
                idx = 0
        dp[i] = cnt
    print(f"#{tc} {min(dp)}")