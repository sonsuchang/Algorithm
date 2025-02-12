def solution(prices):
    answer = []
    length = len(prices)
    for i in range(length):
        cnt = 0
        for j in range(i + 1, length):
            if prices[i] > prices[j]:
                cnt += 1
                break
            cnt += 1
        answer.append(cnt)
    return answer