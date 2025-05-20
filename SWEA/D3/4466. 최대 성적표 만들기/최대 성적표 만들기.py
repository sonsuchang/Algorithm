T = int(input())
for tc in range(1, T + 1):
    N, K = map(int, input().split())
    N_list = list(map(int, input().split()))
    N_list.sort(reverse=True)
    print(f"#{tc} {sum(N_list[:K])}")