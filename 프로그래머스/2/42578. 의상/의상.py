from itertools import product
def solution(clothes):
    clothes_dict = {}
    for i, j in clothes:
        if j not in clothes_dict:
            clothes_dict[j] = 1
        else:
            clothes_dict[j] += 1
    answer = 1
    for i in clothes_dict.values():
        answer *= (i + 1)
    return answer - 1