T = int(input())
for tc in range(1, T + 1):
    N, M = map(int, input().split())
    words = [input().strip() for _ in range(N)]
    used = [False] * N
    answer = 0
    has_center = False

    for i in range(N):
        if used[i]:
            continue
        for j in range(i + 1, N):
            if not used[j] and words[i] == words[j][::-1]:
                used[i] = used[j] = True
                answer += 2 * M
                break

    for i in range(N):
        if not used[i] and words[i] == words[i][::-1]:
            has_center = True
            break

    if has_center:
        answer += M

    print(f"#{tc} {answer}")
