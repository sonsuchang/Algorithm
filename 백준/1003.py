'''
import sys
def recallfunc(N):
    global z_count, o_count
    if N == 0:
        z_count += 1
        return 0
    elif N == 1:
        o_count += 1
        return 0
    else:
        return recallfunc(N - 1) + recallfunc(N - 2)

T = int(sys.stdin.readline())
print_list = []
for _ in range(T):
    z_count = 0
    o_count = 0
    recallfunc(int(sys.stdin.readline()))
    print_list.append([z_count, o_count])

for i in print_list:
    print("{0} {1}".format(i[0], i[1]))
'''
import sys
T = int(sys.stdin.readline())
list_number = []
for _ in range(T):
    list_number.append(int(sys.stdin.readline()))
fibo_list = [[0, 1]]
print_list = []
for i in range(max(list_number)):
    temp = []
    temp.append(fibo_list[i][1])
    temp.append(fibo_list[i][1] + fibo_list[i][0])
    fibo_list.append(temp)
for k in range(len(list_number)):
    if list_number[k] == 0:
        print("{0} {1}".format(1, 0))
    else:
        print("{0} {1}".format(fibo_list[list_number[k] - 1][0], fibo_list[list_number[k] - 1][1]))