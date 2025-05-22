T = int(input())
for tc in range(1, T + 1):
    A, B = map(int, input().split())
    if B - A == 1 or A > B:
        print(f"#{tc} -1")
    else:
        if (B - A) == 0:
            print(f"#{tc} 0")
        else:
            print(f"#{tc} {(B - A) // 2}")