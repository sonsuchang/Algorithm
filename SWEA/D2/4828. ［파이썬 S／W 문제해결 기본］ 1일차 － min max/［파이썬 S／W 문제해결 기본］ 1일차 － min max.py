T = int(input())
for tc in range(1, T + 1):
    N = int(input())
    N_list = list(map(int, input().split()))
    print(f"#{tc} {max(N_list) - min(N_list)}")