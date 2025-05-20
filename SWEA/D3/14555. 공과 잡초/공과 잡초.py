T = int(input())
for tc in range(1, T + 1):
    S = list(input().rstrip())
    answer = 0
    length = len(S)
    i = 0
    while i < length:
        if S[i] == "(":
            if i + 1 < length and S[i + 1] == ")":
                answer += 1
                i += 1
            else:
                answer += 1
        elif S[i] == ")":
            answer += 1
        i += 1
    print(f"#{tc} {answer}")