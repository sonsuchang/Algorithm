def solution(m, n, board):
    board = [list(row) for row in board]
    total_removed = 0

    while True:
        to_remove = set()

        # 2x2 블록 탐색
        for i in range(m - 1):
            for j in range(n - 1):
                block = board[i][j]
                if block == " ":
                    continue
                if block == board[i+1][j] == board[i][j+1] == board[i+1][j+1]:
                    to_remove |= {(i, j), (i+1, j), (i, j+1), (i+1, j+1)}

        if not to_remove:
            break

        # 블록 제거
        for i, j in to_remove:
            board[i][j] = " "

        # 블록 아래로 내리기
        for j in range(n):
            empty = []
            for i in reversed(range(m)):
                if board[i][j] == " ":
                    empty.append(i)
                elif empty:
                    empty_row = empty.pop(0)
                    board[empty_row][j], board[i][j] = board[i][j], " "
                    empty.append(i)

        total_removed += len(to_remove)

    return total_removed
