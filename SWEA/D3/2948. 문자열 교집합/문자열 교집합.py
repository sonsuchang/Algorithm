T = int(input())
for tc in range(1, T + 1):
    N, M = map(int, input().split())
    N_list = set(input().split())
    M_list = set(input().split())
    print(f"#{tc} {len(N_list & M_list)}")