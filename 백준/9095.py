import sys
dp = [1,2,4]
test_case = []
for _ in range(int(sys.stdin.readline())):
    test_case.append(int(sys.stdin.readline()))
for i in range(3, max(test_case)):
    dp.append(dp[i-1] + dp[i-2] + dp[i-3])
for k in test_case:
    print(dp[k-1])