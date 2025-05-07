T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    N_list = sorted(list(map(int, input().split())))
    print(f"#{test_case}", *N_list)