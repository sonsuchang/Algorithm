T = 10
for test_case in range(1, T + 1):
    N = int(input())
    N_list = list(map(int, input().split()))
    result = 0
    if N == 4:
        print(f"#{test_case} {result}")
    else:
        for i in range(2, N - 2):
            a, b, c, d, e = N_list[i - 2], N_list[i - 1], N_list[i], N_list[i + 1], N_list[i + 2]
            if c > a and c > b and c > d and c > e:
                result = result + c - max(a, b, d, e)
        print(f"#{test_case} {result}")