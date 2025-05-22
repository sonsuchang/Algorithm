T = int(input())
for tc in range(1, T + 1):
    S_list = []
    max_length = 0
    for _ in range(5):
        S = list(input().rstrip())
        S_list.append(S)
        max_length = max(len(S), max_length)
    result = ""
    for i in range(max_length):
        for j in range(5):
            if i >= len(S_list[j]):
                continue
            result += S_list[j][i]
    print(f"#{tc} {result}")