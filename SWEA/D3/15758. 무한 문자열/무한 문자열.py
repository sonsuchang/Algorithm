T = int(input())
for tc in range(1, T + 1):
    S, T = input().split()
    S, T = (S * len(T)), (T * len(S))
    if S == T:
        print(f"#{tc} yes")
    else:
        print(f"#{tc} no")
