r_bug = {}

output = 0
n = int(input())
for _ in range(n):
    M, N, K = int(input().split())
    for _ in range(K):
        X, Y = int(input().split())
        if X < 0 and X >= M:
            continue
        if Y < 0 and Y >= N:
            continue
        r_bug[X] = Y
def recursion_func(X, Y):
    
    return recursion_func(X, Y)
recursion_func()
