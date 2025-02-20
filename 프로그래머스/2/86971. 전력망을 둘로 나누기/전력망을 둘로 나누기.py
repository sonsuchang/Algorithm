from collections import deque

def solution(n, wires):
    def bfs(start, graph, visited):
        queue = deque([start])
        visited[start] = True
        count = 1

        while queue:
            node = queue.popleft()
            for neighbor in graph[node]:
                if not visited[neighbor]:
                    visited[neighbor] = True
                    queue.append(neighbor)
                    count += 1
        return count

    min_diff = float('inf')

    for i in range(len(wires)):
        graph = {i: [] for i in range(1, n + 1)}

        for j, (a, b) in enumerate(wires):
            if i == j:
                continue
            graph[a].append(b)
            graph[b].append(a)

        visited = [False] * (n + 1)
        first_group_size = bfs(1, graph, visited)
        second_group_size = n - first_group_size

        diff = abs(first_group_size - second_group_size)
        min_diff = min(min_diff, diff)

    return min_diff
