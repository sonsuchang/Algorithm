num_list = [0] * 10
num_sum = 1
for _ in range(3):
    num_sum *= int(input())
num_sum = str(num_sum)
for i in range(len(num_sum)):
    num_list[int(num_sum[i])] += 1
for k in range(len(num_list)):
    print(num_list[k])
