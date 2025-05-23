T = int(input())
for tc in range(1, T + 1):
    N = int(input())
    N_list = list(map(int, input().split()))
    heap = []
    heap.append(N_list[0])
    for i in range(1, N):
        heap.append(N_list[i])
        child = i
        if child % 2 == 0:
            parent = (child - 2) // 2
            while child > 0 and heap[parent] > heap[child]:
                heap[parent], heap[child] = heap[child], heap[parent]
                child = parent
                if child % 2 == 0:
                    parent = (child - 2) // 2
                else:
                    parent = (child - 1) // 2
        else:
            parent = (child - 1) // 2
            while child > 0 and heap[parent] > heap[child]:
                heap[parent], heap[child] = heap[child], heap[parent]
                child = parent
                if child % 2 == 0:
                    parent = (child - 2) // 2
                else:
                    parent = (child - 1) // 2
    answer = 0
    child = N - 1
    while child > 0:
        if child % 2 == 0:
            child = (child - 2) // 2
            answer += heap[child]
        else:
            child = (child - 1) // 2
            answer += heap[child]
    print(f"#{tc} {answer}")