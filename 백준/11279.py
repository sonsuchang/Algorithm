import sys, heapq

N = int(sys.stdin.readline())

N_list = []

for _ in range(N):
    x = int(sys.stdin.readline())
    if x == 0:
        if len(N_list) == 0:
            print(0)
        else:
            result = heapq.heappop(N_list)
            print(result[1])
    else:
        heapq.heappush(N_list, (-x, x))