import sys, heapq

X = int(sys.stdin.readline())

N_list = []

heapq.heappush(N_list, 64)

while True:
    if sum(N_list) == X:
        break
    more_short = heapq.heappop(N_list)
    short_slice = more_short // 2
    if short_slice + sum(N_list) < X:
        heapq.heappush(N_list, short_slice)
        heapq.heappush(N_list, short_slice)
    else:
        heapq.heappush(N_list, short_slice)
print(len(N_list))