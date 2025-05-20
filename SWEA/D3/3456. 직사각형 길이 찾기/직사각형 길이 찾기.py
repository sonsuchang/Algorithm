T = int(input())
for tc in range(1, T + 1):
    a, b, c = map(int, input().split())
    if a == b == c:
        print(f"#{tc} {a}")
    else:
        if a == b:
            print(f"#{tc} {c}")
        elif a == c:
            print(f"#{tc} {b}")
        else:
            print(f"#{tc} {a}")