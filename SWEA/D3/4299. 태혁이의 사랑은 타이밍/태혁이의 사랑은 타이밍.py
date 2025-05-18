T = int(input())

for tc in range(1, T + 1):
    D, H, M = map(int, input().split())

    base_time = (11 * 24 * 60) + (11 * 60) + 11
    current_time = (D * 24 * 60) + (H * 60) + M

    if current_time < base_time:
        print(f"#{tc} -1")
    else:
        print(f"#{tc} {current_time - base_time}")