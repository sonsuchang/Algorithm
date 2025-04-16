T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    board = []
    for _ in range(N):
        temp = []
        N_list = list(input().rstrip())
        for i in N_list:
            temp.append(int(i))
        board.append(temp)
    if N == 1:
        result = board[0][0]
        print(f"#{test_case} {result}")
    else:
        result = 0
        mid = N // 2
        j = 0
        for i in range(N):
            if i < mid:
                result += sum(board[i][mid - j : mid + j + 1])
                j += 1
            elif i == mid:
                result += sum(board[i][mid - j : mid + j + 1])
            else:
                j -= 1
                result += sum(board[i][mid - j : mid + j + 1])
        print(f"#{test_case} {result}")