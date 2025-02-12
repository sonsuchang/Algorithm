from collections import deque
def solution(priorities, location):
    answer = 0
    length = len(priorities)
    priorities_list = []
    for i in range(length):
        priorities_list.append([priorities[i], i])
    queue = deque(priorities_list)
    max_value = max(priorities)
    while queue:
        now = queue.popleft()
        if now[0] < max_value:
            queue.append(now)
            continue
        else:
            priorities[priorities.index(max_value)] = 0
            max_value = max(priorities)
            answer += 1
        if now[1] == location:
            break
    return answer