T = int(input())
for tc in range(1, T + 1):
    A, B, C, D = map(int, input().split())
    start = max(A, C)
    end = min(B, D)
    overlap = max(0, end - start)
    print(f"#{tc} {overlap}")