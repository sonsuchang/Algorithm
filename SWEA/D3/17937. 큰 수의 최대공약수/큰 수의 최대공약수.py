T = int(input())
for tc in range(1, T + 1):
    A, B = map(int, input().split())
    if A == B:
        print(f"#{tc} {A}")
    else:
        print(f"#{tc} 1")