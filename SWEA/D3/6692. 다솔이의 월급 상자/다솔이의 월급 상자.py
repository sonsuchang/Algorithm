T = int(input())
for tc in range(1, T + 1):
    N = int(input())
    result = 0
    for _ in range(N):
        pi, xi = map(float, input().split())
        result += pi * 100000 * xi
    print(f"#{tc} {result / 100000}")