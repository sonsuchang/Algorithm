from collections import deque
T = int(input())
for tc in range(1, T + 1):
    target = list(input().rstrip())
    target_list = []
    for i in target:
        if i == "{" or i == "}" or i == "(" or i == ")":
            target_list.append(i)
    queue = deque()
    for i in target_list:
        if queue and i == "}" and queue[-1] == "{":
            queue.pop()
        elif queue and i == ")" and queue[-1] == "(":
            queue.pop()
        else:
            queue.append(i)
    if queue:
        print(f"#{tc} 0")
    else:
        print(f"#{tc} 1")