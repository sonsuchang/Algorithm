from itertools import permutations
def solution(k, dungeons):
    dungeons.sort(key = lambda x : x[0], reverse = True)
    length = len(dungeons)
    order = [i for i in range(length)]
    max_value = 0
    for i in permutations(order, length):
        temp = k
        cnt = 0
        for j in i:
            if temp >= dungeons[j][0]:
                temp -= dungeons[j][1]
                cnt += 1
            else:
                break
        if max_value < cnt:
            max_value = cnt
    return max_value