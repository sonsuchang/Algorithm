N = int(input())
Not_cnt_list = []
N_list = list(map(int, input().split()))
for _ in range(N):
    if min(N_list) == 0 or min(N_list) == 1:
        N_list.remove(min(N_list))
cnt = 0
for i in N_list:
    for k in range(2, i):
        if i % k == 0:
            Not_cnt_list.append(i)
    if i not in Not_cnt_list:
        cnt += 1
print(cnt)
