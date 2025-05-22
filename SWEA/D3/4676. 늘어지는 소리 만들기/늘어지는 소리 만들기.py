from collections import Counter
T = int(input())
for tc in range(1, T + 1):
    S = input().rstrip()
    H = int(input())
    H_idx = Counter(list(map(int, input().split())))
    answer = []
    for i in range(len(S)):
        answer.append("")
        answer.append(S[i])
    answer.append("")
    for i, j in H_idx.items():
        answer[i * 2] = "-" * j
    print(f"#{tc} {''.join(answer)}")