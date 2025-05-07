T = int(input())
for test_case in range(1, T + 1):
    N_list = sorted(list(map(int, input().split())))
    answer = round(sum(N_list[1:9]) / 8)
    print(f"#{test_case} {answer}")