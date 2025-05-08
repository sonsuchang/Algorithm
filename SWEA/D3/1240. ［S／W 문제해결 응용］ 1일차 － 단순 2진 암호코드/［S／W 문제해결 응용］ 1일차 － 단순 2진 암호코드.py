T = int(input())
for test_case in range(1, T + 1):
    N, M = map(int, input().split())
    board = [list(map(int, input().rstrip())) for _ in range(N)]
    bit_dict = {0 : [0, 0, 0, 1, 1, 0, 1], 1 : [0, 0, 1, 1, 0, 0, 1], 2 : [0, 0, 1, 0, 0, 1, 1], 3 : [0, 1, 1, 1, 1, 0, 1], 4:[0, 1, 0, 0, 0, 1, 1], 5: [0, 1, 1, 0, 0, 0, 1],
               6:[0, 1, 0, 1, 1, 1, 1], 7 : [0, 1, 1, 1, 0, 1, 1], 8 : [0, 1, 1, 0, 1, 1, 1], 9 : [0, 0, 0, 1, 0, 1, 1]}
    answer = []
    for line in board:
        if 1 in line:
            end = 0
            for i in range(M - 1, -1, -1):
                if line[i] == 1:
                    end = i
                    break
            start = end - 56 + 1
            for i in range(start, end, 7):
                for j in bit_dict.keys():
                    if bit_dict[j] == line[i : i + 7]:
                        answer.append(j)
                        break
            break
    result = (answer[0] + answer[2] + answer[4] + answer[6]) * 3 + answer[1] + answer[3] + answer[5] + answer[7]
    if result % 10 == 0:
        print(f"#{test_case} {sum(answer)}")
    else:
        print(f"#{test_case} 0")