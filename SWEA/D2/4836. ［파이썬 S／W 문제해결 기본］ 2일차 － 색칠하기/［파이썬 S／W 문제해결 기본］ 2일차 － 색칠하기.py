T = int(input())
for tc in range(1, T + 1):
    N = int(input())
    board = [[0] * 10 for _ in range(10)]
    answer = 0
    for _ in range(N):
        x1, y1, x2, y2, color = map(int, input().split())
        for i in range(x1, x2 + 1):
            for j in range(y1, y2 + 1):
                if board[i][j] == 0:
                    board[i][j] += color
                elif board[i][j] != color:
                    board[i][j] += color
                    answer += 1
    print(f"#{tc} {answer}")