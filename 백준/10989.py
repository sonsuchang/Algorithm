def merge_sort(A, p, r):
    if p < r:
        q = (p + r) // 2
        merge_sort(A, p, q)
        merge_sort(A, q + 1, r)
        sorted_list = merge(A, p, q, r)
        return sorted_list

def merge(A, p, q, r):
    i = p
    j = q + 1
    t = 0
    tmp = [0 for i in range(len(A))]
    while i <= q and j <= r:
        if A[i] <= A[j]:
            tmp[t] = A[i]
            t += 1
            i += 1
        else:
            tmp[t] = A[j]
            t += 1
            j += 1
    while i <= q:
        tmp[t] = A[i]
        t += 1
        i += 1
    while j <= r:
        tmp[t] = A[j]
        t += 1
        j += 1
    i = p
    t = 0
    while i <= r:
        A[i] = tmp[t]
        t += 1
        i += 1
    return A
N = int(input())
sort_list = []

for _ in range(N):
    sort_list.append(int(input()))

sort_list = merge_sort(sort_list, 0, len(sort_list) - 1)
for i in range(len(sort_list)):
    print(sort_list[i])
