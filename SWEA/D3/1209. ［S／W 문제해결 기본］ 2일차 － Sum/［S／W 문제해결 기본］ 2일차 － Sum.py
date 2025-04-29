T = 10
for test_case in range(1, T + 1):
    tc = int(input())
    board = [list(map(int, input().split())) for _ in range(100)]
    value = []
    for i in range(100):
        value.append(sum(board[i]))
    for i in range(100):
        temp = 0
        for j in range(100):
            temp += board[j][i]
        value.append(temp)
    temp = 0
    for i in range(100):
        temp += board[i][i]
    value.append(temp)
    temp = 0
    for i in range(100):
        temp += board[i][99 - i]
    value.append(temp)
    answer = max(value)
    print(f"#{tc} {answer}")