import sys

'''
n = 1 : 1
n = 2 : 2
n = 3 : 3
n = 4 : 5
n = 5 : 8
n = 6 : 13
n = 7 : 21
n = 8 : 34
n = 9 : 55
'''

N = int(sys.stdin.readline())
dp = [1, 2]
if N <= 2:
    print(dp[N - 1] % 10007)
else:
    for i in range(2, N):
        dp.append(dp[i - 2] + dp[i - 1])
    print(dp[N - 1] % 10007)