def solution(msg):
    str_dict = {}
    num = 1
    for i in range(65, 91):
        str_dict[chr(i)] = num
        num += 1
    idx = 0
    length = len(msg)
    answer = []
    temp = ""
    while True:
        if len(temp) == 0:
            temp = msg[idx]
        idx += 1
        if idx >= length:
            break
        if temp + msg[idx] not in str_dict.keys():
            answer.append(str_dict[temp])
            str_dict[temp + msg[idx]] = num
            num += 1
            temp = ""
        else:
            temp += msg[idx]
    answer.append(str_dict[temp])
    return answer