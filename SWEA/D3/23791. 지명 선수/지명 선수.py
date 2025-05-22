from collections import deque
T = int(input())
for tc in range(1, T + 1):
    N = int(input())
    A = deque(map(int, input().split()))
    B = deque(map(int, input().split()))
    N_list = [0] * N
    while A and B:
        while A:
            select_a = A.popleft()
            if N_list[select_a - 1] == 0:
                N_list[select_a - 1] = "A"
                break
        while B:
            select_b = B.popleft()
            if N_list[select_b - 1] == 0:
                N_list[select_b - 1] = "B"
                break
    print(''.join(N_list))