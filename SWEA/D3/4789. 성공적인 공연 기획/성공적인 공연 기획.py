T = int(input())
for tc in range(1, T + 1):
    S = list(map(int, input().rstrip()))
    a, e = 0, 0
    for i in range(len(S)):
        a += S[i]
        if a <= i:
            e += 1
            a += 1
    print(f"#{tc} {e}")