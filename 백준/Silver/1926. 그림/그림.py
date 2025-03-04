from collections import deque
import sys
input = sys.stdin.readline

n, m = map(int, input().split())

grid = [list(map(int, input().split())) for _ in range(n)]
visited = [[0] * m for _ in range(n)]

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

def bfs(sx, sy):
    queue = deque([(sx, sy)])
    visited[sx][sy] = 1
    area = 0

    while queue:
        x, y = queue.popleft()
        area += 1
        
        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]
            
            if 0 <= nx < n and 0 <= ny < m:
                if grid[nx][ny] == 1 and visited[nx][ny] == 0:
                    visited[nx][ny] = 1
                    queue.append((nx, ny))
    
    return area

count = 0
max_area = 0

for i in range(n):
    for j in range(m):
        if grid[i][j] == 1 and visited[i][j] == 0:
            count += 1
            max_area = max(max_area, bfs(i, j))

print(count)
print(max_area)
