T = int(input())
for tc in range(1, T + 1):
    N = int(input())
    N_list = [int(input()) for _ in range(N)]
    N_avg = sum(N_list) // N
    answer = 0
    for i in N_list:
        if i > N_avg:
            answer += i - N_avg
    print(f"#{tc} {answer}")