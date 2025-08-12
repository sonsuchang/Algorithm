import sys
from itertools import permutations

N = int(sys.stdin.readline())
num_list = list(map(int, sys.stdin.readline().split()))
opertion_cnt = list(map(int, sys.stdin.readline().split()))
opertion_list = (['+'] * opertion_cnt[0]) + (['-'] * opertion_cnt[1]) + (['*'] * opertion_cnt[2]) + (['//'] * opertion_cnt[3])
operation_set = set(permutations(opertion_list, N - 1))
sum_set = set()
k = 1
for i in operation_set:
    cal_num = num_list[0]
    for j in i:
        if j == '+':
            cal_num += num_list[k]
        elif j == '-':
            cal_num -= num_list[k]
        elif j == '*':
            cal_num *= num_list[k]
        elif j == '//':
            if cal_num < 0:
                cal_num = -(abs(cal_num) // num_list[k])
            else:
                cal_num = cal_num // num_list[k]
        k += 1
    k = 1
    sum_set.add(cal_num)
print(max(sum_set))
print(min(sum_set))