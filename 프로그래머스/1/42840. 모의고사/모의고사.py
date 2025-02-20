def solution(answers):
    length = len(answers)
    human1 = [1, 2, 3, 4, 5] * length
    human2 = [2, 1, 2, 3, 2, 4, 2, 5] * length
    human3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5] * length
    answer = [0, 0, 0]
    for i in range(length):
        if human1[i] == answers[i]:
            answer[0] += 1
        if human2[i] == answers[i]:
            answer[1] += 1
        if human3[i] == answers[i]:
            answer[2] += 1
    max_value = max(answer)
    result = []
    for i in range(3):
        if max_value == answer[i]:
            result.append(i + 1)
    return result