T = int(input())
for test_case in range(1, T + 1):
    N, M, K = map(int, input().split())
    N_list = sorted(list(map(int, input().split())))
    state = "Possible"
    for i in range(N):
        made = (N_list[i] // M) * K
        if made < i + 1:
            state = "Impossible"
            break
    print(f"#{test_case} {state}")