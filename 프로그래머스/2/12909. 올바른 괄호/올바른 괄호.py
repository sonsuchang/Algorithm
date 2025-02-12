def solution(s):
    s = list(s)
    queue = []
    for i in s:
        if i == ')' and queue and queue[-1] == '(':
            queue.pop()
        else:
            queue.append(i)
    if queue:
        return False
    else:
        return True