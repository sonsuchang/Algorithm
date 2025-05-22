T = int(input())
for tc in range(1, T + 1):
    S_list = list(input().split())
    S, K = S_list[0], int(S_list[1])
    while K > 0:
        if S == ".o.":
            S = "o.."
        elif S == "o..":
            S = ".o."
        elif S == "..o":
            S = ".o."
        K -= 1
    print(f"#{tc} {S.index('o')}")