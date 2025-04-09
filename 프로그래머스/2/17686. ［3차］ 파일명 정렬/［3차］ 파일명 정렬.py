def solution(files):
    file_dict = {}
    for i, j in enumerate(files):
        file = []
        idx = 0
        length = len(j)
        while idx < length:
            if j[idx].isdigit():
                break
            else:
                idx += 1
        file.append(j[:idx])
        head = idx
        while idx < length:
            if j[idx].isdigit():
                idx += 1
            else:
                break
        file.append(j[head:idx])
        file.append(j[idx:])
        file_dict[i] = file
    result = sorted(file_dict.items(), key = lambda x : (x[1][0].lower(), int(x[1][1])))
    answer = []
    for i in result:
        answer.append("".join(i[1]))
    return answer