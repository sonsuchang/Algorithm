from collections import Counter
T = int(input())
for tc in range(1, T + 1):
    N = int(input())
    N_list = list(map(int, input().rstrip()))
    counter = Counter(N_list)
    answer = sorted(counter.items(), key = lambda x : (x[1], x[0]), reverse = True)
    print(f"#{tc} {answer[0][0]} {answer[0][1]}")