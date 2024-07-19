import sys

string_a = ' ' + sys.stdin.readline().rstrip()
string_b = ' ' + sys.stdin.readline().rstrip()
dp = [[0] * len(string_b) for _ in range(len(string_a))]

a_length = len(string_a)
b_length = len(string_b)
for i in range(1, a_length):
    for j in range(1, b_length):
        if string_a[i] == string_b[j]:
            dp[i][j] = dp[i - 1][j - 1] + 1
        else:
            dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

if dp[-1][-1] == 0:
    print(0)

else:
    new_string = ""
    a_length -= 1
    b_length -= 1
    while True:
        if a_length == 0 or b_length == 0:
            break
        if string_a[a_length] == string_b[b_length]:
            new_string = string_a[a_length] + new_string
            a_length -= 1
            b_length -= 1
        else:
            if dp[a_length - 1][b_length] < dp[a_length][b_length - 1]:
                b_length -= 1
            else:
                a_length -= 1
    print(dp[-1][-1])
    print(new_string)