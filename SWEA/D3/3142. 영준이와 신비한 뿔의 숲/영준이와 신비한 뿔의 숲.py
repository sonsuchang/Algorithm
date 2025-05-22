T = int(input())
for tc in range(1, T + 1):
    n, m = map(int, input().split())
    t = 0
    while n != m:
        n -= 2
        m -= 1
        t += 1
    print(f"#{tc} {n} {t}")