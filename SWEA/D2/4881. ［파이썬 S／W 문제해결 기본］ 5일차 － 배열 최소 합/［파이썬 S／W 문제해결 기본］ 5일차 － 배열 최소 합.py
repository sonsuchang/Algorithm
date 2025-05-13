def dfs(depth, total):
    global min_value

    if total >= min_value:
        return

    if depth == N:
        min_value = total
        return

    for i in range(N):
        if not visited[i]:
            visited[i] = 1
            dfs(depth + 1, total + board[depth][i])
            visited[i] = 0

T = int(input())
for tc in range(1, T + 1):
    N = int(input())
    board = [list(map(int, input().split())) for _ in range(N)]
    visited = [0] * N
    min_value = float('inf')
    dfs(0, 0)
    print(f"#{tc} {min_value}")