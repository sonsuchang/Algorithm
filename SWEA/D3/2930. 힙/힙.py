import heapq
T = int(input())
for tc in range(1, T + 1):
    N = int(input())
    heap = []
    answer = []
    for _ in range(N):
        temp = list(map(int, input().split()))
        if len(temp) == 1:
            if len(heap) == 0:
                answer.append("-1")
            else:
                num = heapq.heappop(heap)
                answer.append(str(num[1]))
        else:
            heapq.heappush(heap, (-temp[1], temp[1]))
    print(f"#{tc} {' '.join(answer)}")