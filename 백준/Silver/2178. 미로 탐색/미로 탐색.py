from collections import deque
import sys

N, M = map(int, sys.stdin.readline().split())
maps = []
for _ in range(N):
    maps.append(list(map(int, sys.stdin.readline().strip('\n'))))
queue = deque([(0, 0, 1)])
visited = [[False] * M for _ in range(N)]
moves = [(0, 1), (1, 0), (0, -1), (-1, 0)]
count = 0
while queue:
    now = queue.popleft()
    if now[0] == N - 1 and now[1] == M - 1:
        print(now[2])
    for add_x, add_y in moves:
        new_x, new_y = now[0] + add_x, now[1] + add_y
        if new_x >= 0 and new_x <= (N - 1) and new_y >= 0 and new_y <= (M - 1) and maps[new_x][new_y] == 1 and visited[new_x][new_y] == False:
            queue.append((new_x, new_y, now[2] + 1))
            visited[new_x][new_y] = True