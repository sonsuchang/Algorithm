from collections import Counter
T = int(input())
for tc in range(1, T + 1):
    S = Counter(list(input().rstrip()))
    answer = "No"
    if len(S) == 2:
        cnt = 0
        for i in S.values():
            if i == 2:
                cnt += 1
        if cnt == 2:
            answer = "Yes"
    print(f"#{tc} {answer}")