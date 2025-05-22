T = int(input())
for tc in range(1, T + 1):
    N, M = map(int, input().split())
    N_list = list(input().split())
    M_list = list(input().split())
    Q = int(input())
    answer = []
    for _ in range(Q):
        Y = int(input())
        temp = ""
        a = Y % N
        b = Y % M
        if a == 0:
            temp += N_list[-1]
        else:
            temp += N_list[a - 1]
        if b == 0:
            temp += M_list[-1]
        else:
            temp += M_list[b - 1]
        answer.append(temp)
    print(f"#{tc}", *answer)