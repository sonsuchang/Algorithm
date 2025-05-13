from collections import deque
import math

T = int(input())
for tc in range(1, T + 1):
    V, E = map(int, input().split())
    graph = {}
    for i in range(1, V + 1):
        graph[i] = []
    for _ in range(E):
        node1, node2 = map(int, input().split())
        graph[node1].append(node2)
        graph[node2].append(node1)
    start, end = map(int, input().split())
    queue = deque()
    min_value = math.inf
    visited = [0] * (V + 1)
    for i in graph[start]:
        queue.append([start, i, 1])
    while queue:
        now = queue.popleft()
        x, y, cnt = now[0], now[1], now[2]
        visited[x] = 1
        if y == end:
            min_value = min(min_value, cnt)
        for i in graph[y]:
            if visited[i] == 0:
                queue.append([y, i, cnt + 1])
    if min_value == math.inf:
        print(f"#{tc} 0")
    else:
        print(f"#{tc} {min_value}")