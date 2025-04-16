T = int(input())
for test_case in range(1, T + 1):
    board = [list(map(int,  input().split())) for _ in range(9)]
    br = 0
    for i in range(9):
        if sum(board[i]) != 45:
            br = 1
            break
    if br == 0:
        for i in range(9):
            result = 0
            for j in range(9):
                result += board[j][i]
            if result != 45:
                br = 1
                break
    if br == 0:
        check = [0, 0, 0]
        for i in range(9):
            if i != 0 and i % 3 == 0:
                if check[0] != 45 or check[1] != 45 or check[2] != 45:
                    br = 1
                    break
                check = [0, 0, 0]
            check[0] += sum(board[i][0:3])
            check[1] += sum(board[i][3:6])
            check[2] += sum(board[i][6:])
        if check[0] != 45 or check[1] != 45 or check[2] != 45:
            br = 1
    if br == 0:
        print(f"#{test_case} 1")
    else:
        print(f"#{test_case} 0")