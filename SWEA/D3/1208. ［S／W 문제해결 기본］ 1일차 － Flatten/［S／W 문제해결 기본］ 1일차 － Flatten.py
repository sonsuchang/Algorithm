import heapq
T = 10
for test_case in range(1, T + 1):
    num = int(input())
    num_list = list(map(int, input().split()))
    heap = []
    for i in num_list:
        heapq.heappush(heap, i)
    for i in range(num):
        temp = []
        min_value = heapq.heappop(heap) + 1
        heapq.heappush(temp, min_value)
        for _ in range(98):
            heapq.heappush(temp, heapq.heappop(heap))
        heapq.heappush(temp, heapq.heappop(heap) - 1)
        heap = temp
    min_value = heapq.heappop(heap)
    for _ in range(98):
        heapq.heappop(heap)
    max_value = heapq.heappop(heap)
    result = max_value - min_value
    print(f"#{test_case} {result}")
    