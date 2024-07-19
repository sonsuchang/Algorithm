import sys
from collections import deque

N = int(sys.stdin.readline())
card_queue = deque()
for i in range(1, N+1):
    card_queue.append(i)
while len(card_queue) != 1:
    card_queue.popleft()
    temp = card_queue.popleft()
    card_queue.append(temp)
print(card_queue[0])
