def solution(progresses, speeds):
    length = len(progresses)
    for i in range(length):
        x = 100 - progresses[i]
        if x % speeds[i] == 0:
            progresses[i] = x // speeds[i]
        else:
            progresses[i] = x // speeds[i] + 1
    answer = []
    start = progresses[0]
    cnt = 1
    for i in range(1, length):
        if progresses[i] <= start:
            cnt += 1
        else:
            answer.append(cnt)
            start = progresses[i]
            cnt = 1
    answer.append(cnt)
    return answer