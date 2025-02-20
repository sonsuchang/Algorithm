def solution(sizes):
    size_length = len(sizes)
    max_length1 = 0
    for i in range(size_length):
        sizes[i].sort()
        if max_length1 < sizes[i][1]:
            max_length1 = sizes[i][1]
    max_length2 = 0
    for i in range(size_length):
        if max_length2 < sizes[i][0]:
            max_length2 = sizes[i][0]
    return max_length1 * max_length2