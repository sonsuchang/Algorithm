import sys
N = int(sys.stdin.readline())
factorial_list = [2]
for i in range(3, N + 1):
    factorial_list.append(factorial_list[i-3] * i)
result_num = str(factorial_list[-1])
cnt = 0
for k in range(-1, -1 * (len(result_num)), -1):
    if result_num[k] != '0':
        break
    else:
        cnt += 1
print(cnt)