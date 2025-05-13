from collections import deque

T = int(input())
for tc in range(1, T + 1):
    N = int(input())
    board = [list(map(int, input().rstrip())) for _ in range(N)]
    visited = [[0] * N for _ in range(N)]
    queue = deque()
    for i in range(N):
        for j in range(N):
            if board[i][j] == 2:
                queue.append([i, j])
    dx = [-1, 1, 0, 0]
    dy = [0, 0, 1, -1]
    answer = 0
    while queue:
        now = queue.popleft()
        x, y = now[0], now[1]
        if board[x][y] == 3:
            answer = 1
            break
        visited[x][y] = 1
        for i, j in zip(dx, dy):
            nx, ny = x + i, y + j
            if 0 <= nx < N and 0 <= ny < N and visited[nx][ny] == 0 and board[nx][ny] != 1:
                queue.append([nx, ny])
    print(f"#{tc} {answer}")