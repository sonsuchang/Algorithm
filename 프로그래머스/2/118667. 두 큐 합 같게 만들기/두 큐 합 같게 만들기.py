from collections import deque
import copy
def solution(queue1, queue2):
    queue1 = deque(queue1)
    queue2 = deque(queue2)
    sum_q1 = sum(queue1)
    sum_q2 = sum(queue2)
    answer = 0
    target = (sum(queue1) + sum(queue2)) // 2
    br = 0
    while True:
        if br == 600000:
            answer = -1
            break
        if sum_q1 == sum_q2:
            break
        if sum_q1 > sum_q2:
            temp = queue1.popleft()
            queue2.append(temp)
            sum_q1 -= temp
            sum_q2 += temp
            answer += 1
        else:
            temp = queue2.popleft()
            queue1.append(temp)
            sum_q2 -= temp
            sum_q1 += temp
            answer += 1
        br += 1
    return answer