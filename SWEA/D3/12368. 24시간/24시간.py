T = int(input())
for tc in range(1, T + 1):
    a, b = map(int, input().split())
    result = a + b
    while result >= 24:
        result -= 24
    print(f"#{tc} {result}")