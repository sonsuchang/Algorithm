N = int(input())
N_list = []
max_list = []
N_count_list = [0] * 8001
for _ in range(N):
    temp = int(input())
    N_list.append(temp)
    N_count_list[temp + 4000] += 1
N_list.sort()
N_max = 0
for i in range(len(N_count_list)):
    if N_count_list[i] > N_max:
        N_max = N_count_list[i]
for k in range(len(N_count_list)):
    if N_count_list[k] == N_max:
        max_list.append(k)
print(round(sum(N_list) / len(N_list)))
print(N_list[len(N_list) // 2])
if len(max_list) == 1:
    print(max_list[0] - 4000)
else:
    print(max_list[1] - 4000)
print(N_list[-1] - N_list[0])
