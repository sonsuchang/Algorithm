def solution(cacheSize, cities):
    if cacheSize == 0:
        return len(cities) * 5
    cache = []
    idx = 0
    length = len(cities)
    answer = 0
    while idx < length:
        target = cities[idx].lower()
        if target in cache:
            answer += 1
            cache.remove(target)
        elif len(cache) == cacheSize:
            answer += 5
            cache.pop(0)
        else:
            answer += 5
        cache.append(target)
        idx += 1
    return answer