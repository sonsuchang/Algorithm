import heapq
def solution(jobs):
    length = len(jobs)
    heapq.heapify(jobs)
    answer = 0
    time = 0
    cnt = 0
    while True:
        if cnt == length:
            break
        queue = []
        for _ in range(len(jobs)):
            if jobs[0][0] <= time:
                queue.append(heapq.heappop(jobs))
            else:
                break
        if len(queue) == 0:
            time += 1
            continue
        queue.sort(key = lambda x : (x[1], x[0]))
        now = queue[0]
        answer += time - now[0] + now[1]
        time += now[1]
        cnt += 1
        for i in range(1, len(queue)):
            heapq.heappush(jobs, queue[i])
    return answer // length