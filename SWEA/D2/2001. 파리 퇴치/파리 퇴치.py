T = int(input())
for test_case in range(1, T + 1):
    N, M = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(N)]
    max_value = 0
    for i in range(N - M + 1):
        for j in range(N - M + 1):
            value = 0
            for x in range(i, i + M):
                for y in range(j, j + M):
                    value += board[x][y]
            max_value = max(value, max_value)
    print(f"#{test_case} {max_value}")