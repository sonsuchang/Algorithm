T = int(input())
for tc in range(1, T + 1):
    a, b, c = map(int, input().split())
    count = 0
    if b >= c:
        count += b - c + 1
        b = c - 1
    if a >= b:
        count += a - b + 1
        a = b - 1
    if a < 1 or b < 1 or c < 1:
        count = -1
    
    print(f"#{tc} {count}")