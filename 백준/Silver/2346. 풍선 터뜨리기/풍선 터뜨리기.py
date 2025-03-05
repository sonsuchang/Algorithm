from collections import deque
import sys

input = sys.stdin.readline

N = int(input())

N_list = list(map(int, input().split()))
answer = []
queue = deque()

for i in range(1, N + 1):
    queue.append([i, N_list[i - 1]])

while queue:
    now = queue.popleft()
    answer.append(now[0])
    if len(queue) == 0:
        break
    if now[1] < 0:
        for i in range(abs(now[1])):
            temp = queue.pop()
            queue.appendleft(temp)
    else:
        for i in range(now[1] - 1):
            temp = queue.popleft()
            queue.append(temp)
print(*answer)