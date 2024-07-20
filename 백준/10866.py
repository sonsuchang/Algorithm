import sys
from collections import deque

N = int(sys.stdin.readline())

N_deque = deque()

for _ in range(N):
    temp = sys.stdin.readline().split()
    if temp[0] == "push_front":
        N_deque.appendleft(int(temp[1]))
    elif temp[0] == "push_back":
        N_deque.append(int(temp[1]))
    elif temp[0] == "pop_front":
        if len(N_deque) > 0:
            print(N_deque.popleft())
        else:
            print("-1")
    elif temp[0] == "pop_back":
        if len(N_deque) > 0:
            print(N_deque.pop())
        else:
            print("-1")
    elif temp[0] == "size":
        print(len(N_deque))
    elif temp[0] == "empty":
        if len(N_deque) > 0:
            print("0")
        else:
            print("1")
    elif temp[0] == "front":
        if len(N_deque) > 0:
            print(N_deque[0])
        else:
            print("-1")
    elif temp[0] == "back":
        if len(N_deque) > 0:
            print(N_deque[-1])
        else:
            print("-1")