from collections import deque
import sys, math

N, K = map(int, sys.stdin.readline().split())

visited = [math.inf] * 100001

queue = deque()
queue.append([N, 0])
answer = 0
while queue:
    now, cnt = queue.popleft()
    visited[now] = min(visited[now], cnt)
    if 0 <= now - 1 <= 100000 and visited[now - 1] == math.inf:
        queue.append([now - 1, cnt + 1])
    if 0 <= now + 1 <= 100000 and visited[now + 1] == math.inf:
        queue.append([now + 1, cnt + 1])
    if now * 2 <= 100000 and visited[now * 2] == math.inf:
        queue.append([now * 2, cnt])
print(visited[K])