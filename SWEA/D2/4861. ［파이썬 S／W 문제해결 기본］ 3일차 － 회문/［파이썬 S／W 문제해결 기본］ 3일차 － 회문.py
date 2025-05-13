T = int(input())
for tc in range(1, T + 1):
    N, M = map(int, input().split())
    board = [list(input().rstrip()) for _ in range(N)]
    answer = ""
    for i in range(N):
        for j in range(N - M + 1):
            target = board[i][j:j+M]
            if target == target[::-1]:
                answer = target
    for i in range(N):
        for j in range(N - M + 1):
            target = ""
            for k in range(j, j + M):
                target += board[k][i]
            if target == target[::-1]:
                answer = target
    print(f"#{tc} {''.join(answer)}")