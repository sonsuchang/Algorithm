T = int(input())
for tc in range(1, T + 1):
    A, B, N = map(int, input().split())
    answer = 0
    while A <= N and B <= N:
        if A < B:
            A += B
        else:
            B += A
        answer += 1
    print(answer)