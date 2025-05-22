from collections import deque
T = 10
for tc in range(1, T + 1):
    N = int(input())
    N_list = list(input().split())
    num = int(input())
    commands = deque(input().split())
    while commands:
        now = commands.popleft()
        if now == "I":
            idx = int(commands.popleft())
            cnt = int(commands.popleft())
            temp = []
            for _ in range(cnt):
                temp.append(commands.popleft())
            N_list = N_list[:idx] + temp + N_list[idx:]
        elif now == "D":
            idx = int(commands.popleft())
            cnt = int(commands.popleft())
            N_list = N_list[:idx] + N_list[idx + cnt:]
    print(f"#{tc} {' '.join(N_list[:10])}")