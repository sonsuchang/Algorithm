from collections import deque
import sys

input = sys.stdin.readline

N = int(input())

N_list = []

for _ in range(N):
    x, y = map(int, input().split())
    N_list.append([x, y])
    
N_list.sort(key = lambda x : (x[1], x[0]), reverse = True)

queue = deque(N_list)
idx = 0
length = 0
x, y = queue.popleft()

while queue:
    nx, ny = queue.popleft()
    if x > ny and y > ny:
        length += (y - x)
        x, y = nx, ny
    elif x > nx:
        x = nx
length += (y - x)
print(length)