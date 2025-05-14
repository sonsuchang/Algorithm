from collections import deque
T = 10
for tc in range(1, T + 1):
    N = int(input())
    origin = input().split()
    command_num = int(input())
    commands = deque(input().split())
    while commands:
        command = commands.popleft()
        if command == "I":
            idx = int(commands.popleft())
            cnt = int(commands.popleft())
            temp = [commands.popleft() for _ in range(cnt)]
            origin = origin[:idx] + temp + origin[idx:]
    print(f"#{tc} {' '.join(origin[:10])}")