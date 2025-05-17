T = int(input())
for tc in range(1, T + 1):
    N = int(input())
    N_list = sorted(list(map(int, input().split())), reverse=True)
    length = 2 * N
    answer = []
    visited = [0] * length
    for i in range(length):
        if visited[i] == 0:
            target = (N_list[i] * 3) // 4
            for j in range(i + 1, length):
                if N_list[j] == target and visited[j] == 0:
                    answer.append(target)
                    visited[j] = 1
                    break
    answer.sort()
    print(f"#{tc}", *answer)