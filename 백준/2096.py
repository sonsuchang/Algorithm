import sys

N = int(sys.stdin.readline())

one, two, three = map(int, sys.stdin.readline().split())
max_dp = [one, two, three]
min_dp = [one, two, three]

for _ in range(N - 1):
    x, y, z = map(int, sys.stdin.readline().split())
    max_temp1 = max(max_dp[0], max_dp[1]) + x
    max_temp2 = max(max_dp[0], max_dp[1], max_dp[2]) + y
    max_temp3 = max(max_dp[1], max_dp[2]) + z
    
    max_dp = [max_temp1, max_temp2, max_temp3]

    min_temp1 = min(min_dp[0], min_dp[1]) + x
    min_temp2 = min(min_dp[0], min_dp[1], min_dp[2]) + y 
    min_temp3 = min(min_dp[1], min_dp[2]) + z

    min_dp = [min_temp1, min_temp2, min_temp3]

print(max(max_dp), min(min_dp))