import heapq
def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    while scoville:
        if len(scoville) == 1:
            if scoville[0] < K:
                answer = -1
            break
        if scoville[0] >= K:
            break
        min_scovil1 = heapq.heappop(scoville)
        min_scovil2 = heapq.heappop(scoville)
        heapq.heappush(scoville, min_scovil1 + (min_scovil2 * 2))
        answer += 1
    return answer