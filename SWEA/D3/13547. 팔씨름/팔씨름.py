T = int(input())
for tc in range(1, T + 1):
    S = list(input().rstrip())
    if S.count("x") < 8:
        print(f"#{tc} YES")
    else:
        print(f"#{tc} NO")