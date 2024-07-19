num_list = []
for i in range(9):
    num = int(input())
    num_list.append(num)
max_num = max(num_list)
index_num = num_list.index(max_num)
print(max_num)
print(index_num+1)
