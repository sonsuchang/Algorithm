from collections import deque

T = 10
for tc in range(1, T + 1):
    N, target = input().split()
    N = int(N)
    queue = deque()
    for i in range(N):
        if not queue:
            queue.append(target[i])
        else:
            if target[i] == queue[-1]:
                queue.pop()
            else:
                queue.append(target[i])
    print(f"#{tc} {''.join(queue)}")