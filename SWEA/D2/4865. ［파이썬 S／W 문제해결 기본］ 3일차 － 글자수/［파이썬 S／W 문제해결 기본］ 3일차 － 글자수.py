T = int(input())
for tc in range(1, T + 1):
    str1 = list(input().rstrip())
    str2 = input().rstrip()
    max_value = 0
    for i in str1:
        max_value = max(max_value, str2.count(i))
    print(f"#{tc} {max_value}")
