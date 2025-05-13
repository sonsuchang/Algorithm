from collections import deque

T = int(input())
for tc in range(1, T + 1):
    V, E = map(int, input().split())
    node = {}
    for i in range(1, V + 1):
        node[i] = []
    for _ in range(E):
        x, y = map(int, input().split())
        node[x].append(y)
    visited = [0] * (V + 1)
    queue = deque()
    S, G = map(int, input().split())
    queue.append(S)
    answer = 0
    while queue:
        now = queue.popleft()
        if now == G:
            answer = 1
            break
        visited[now] = 1
        for i in node[now]:
            if visited[i] == 0:
                queue.append(i)
    print(f"#{tc} {answer}")