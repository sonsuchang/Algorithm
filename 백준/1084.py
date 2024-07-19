import sys

input = sys.stdin.readline

N = int(input())

queue = []

for _ in range(N):
    a = input().split()
    if a[0] == 'push':
        queue.append(a[1])
    elif a[0] == 'pop':
        if len(queue) > 0:
            print(queue.pop(0))
        else:
            print("-1")
    elif a[0] == 'size':
        print(len(queue))
    elif a[0] == 'empty':
        if len(queue) > 0:
            print("0")
        else:
            print("1")
    elif a[0] == 'front':
        if len(queue) > 0:
            print(queue[0])
        else:
            print("-1")
    elif a[0] == 'back':
        if len(queue) > 0:
            print(queue[-1])
        else:
            print("-1")