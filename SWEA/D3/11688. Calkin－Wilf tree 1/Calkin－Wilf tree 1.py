T = int(input())
for tc in range(1, T + 1):
    S = input().rstrip()
    S_list = [(1, 1)]
    length = len(S)
    for i in range(length):
        a, b = S_list[-1][0], S_list[-1][1]
        if S[i] == "L":
            S_list.append((a, a + b))
        else:
            S_list.append((a + b, b))
    print(f"#{tc} {S_list[-1][0]} {S_list[-1][1]}")