from itertools import combinations
T = int(input())
for test_case in range(1, T + 1):
    value = []
    N, limit = map(int, input().split())
    N_list = [list(map(int, input().split())) for _ in range(N)]
    for j in range(1, N + 1):
        for i in combinations(N_list, j):
            cal = 0
            feel = 0
            br = 0
            for x in i:
                if cal + x[1] < limit:
                    cal += x[1]
                    feel += x[0]
                else:
                    br = 1
                    break
            if br == 0:
	            value.append(feel)
    max_value = max(value)
    print(f"#{test_case} {max_value}")