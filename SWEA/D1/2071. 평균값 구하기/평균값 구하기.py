T = int(input())
for test_case in range(1, T + 1):
    N_list = list(map(int, input().split()))
    result = round(sum(N_list) / len(N_list))
    print(f"#{test_case} {result}")