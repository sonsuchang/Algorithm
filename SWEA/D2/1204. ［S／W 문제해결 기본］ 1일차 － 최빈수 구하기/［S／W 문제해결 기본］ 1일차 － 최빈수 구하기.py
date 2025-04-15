from collections import Counter
T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    N_list = list(map(int, input().split()))
    N_counter = Counter(N_list)
    result = sorted(N_counter.items(), key = lambda x : (x[1], x[0]), reverse = True)
    print(f"#{N} {result[0][0]}")