T = int(input())
for tc in range(1, T + 1):
    N = int(input())
    board = [list(map(int, input().split())) for _ in range(N)]
    r = [i for i in range(2, N ** 2, N + 1)]
    r.sort(reverse=True)
    check = [(i - 1, i) for i in range(N - 1, 0, -1)]
    answer = 0
    for i in range(N - 1):
        x, y = check[i][0], check[i][1]
        if board[x][y] != r[i]:
            if i != N - 2:
                for nx, ny in check[i+1:]:
                    board[nx][ny], board[ny][nx] = board[ny][nx], board[nx][ny]
            answer += 1
    print(answer)