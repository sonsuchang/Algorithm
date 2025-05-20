from collections import Counter
T = int(input())
for tc in range(1, T + 1):
    counter = Counter(list(input().rstrip()))
    answer = []
    for i, j in counter.items():
        if j % 2 == 1:
            answer.append(i)
    answer.sort()
    if len(answer) == 0:
        print(f"#{tc} Good")
    else:
        print(f"#{tc} {''.join(answer)}")