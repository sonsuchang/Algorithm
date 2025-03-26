def solution(s):
    answer = {}
    s = s.split("}")
    for i in s:
        temp = ""
        for j in i:
            if j.isdigit():
                temp += j
            elif j == "," and len(temp) > 0:
                if int(temp) in answer.keys():
                    answer[int(temp)] += 1
                else:
                    answer[int(temp)] = 1
                temp = ""
        if len(temp) > 0:
            if int(temp) in answer.keys():
                    answer[int(temp)] += 1
            else:
                answer[int(temp)] = 1
    answer = sorted(answer.items(), key = lambda x : x[1], reverse = True)
    result = []
    for i, j in answer:
        result.append(i)
    return result