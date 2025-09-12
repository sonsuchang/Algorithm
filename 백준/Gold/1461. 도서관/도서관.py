from collections import deque
N, M = map(int, input().split())
book_list = list(map(int, input().split()))

book_list.sort()
pos = []
neg = []
cal_list = []
for i in book_list:
    if i > 0:
        pos.append(i)
    else:
        neg.append(abs(i))
pos.sort(reverse=True)
neg.sort(reverse=True)

for i in range(len(pos)):
    if i % M == 0:
        cal_list.append(pos[i])
for i in range(len(neg)):
    if i % M == 0:
        cal_list.append(neg[i])
cal_list.sort()
print(sum(cal_list) * 2 - cal_list[-1])