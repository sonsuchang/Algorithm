T = int(input())
for tc in range(1, T + 1):
    board = [list(input().rstrip()) for _ in range(8)]
    answer = True
    for i in range(8):
        if board[i].count("O") != 1:
            answer = False
            break
    if answer:
        for i in range(8):
            cnt = 0
            for j in range(8):
                if board[j][i] == "O":
                    cnt += 1
            if cnt != 1:
                answer = False
                break
    if answer:
        print(f"#{tc} yes")
    else:
        print(f"#{tc} no")