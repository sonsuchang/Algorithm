T = int(input())
for tc in range(1, T + 1):
    N = int(input())
    N_list = list(map(int, input().split()))
    avg_N = sum(N_list) / N
    count = 0
    for i in N_list:
        if i <= avg_N:
            count += 1
    print(f"#{tc} {count}")