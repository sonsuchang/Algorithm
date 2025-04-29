T = 10
for test_case in range(1, T + 1):
    target = int(input())
    board = [list(input().rstrip()) for _ in range(8)]
    answer = 0
    for i in range(8):
        for j in range(8 - target + 1):
            check = board[i][j : j + target]
            if check == check[::-1]:
                answer += 1
    for i in range(8):
        for k in range(8 - target + 1):
            check = ""
            for j in range(k, k + target):
                check += board[j][i]
            if check == check[::-1]:
                answer += 1
    print(f"#{test_case} {answer}")