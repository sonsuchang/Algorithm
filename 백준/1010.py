import sys

input = sys.stdin.readline

T = int(input())

for _ in range(T):
    M, N = map(int, input().split())
    farent = 1
    for i in range(2, M + 1):
        farent *= i
    child = 1
    for i in range(N, N - M, -1):
        child *= i
    print(child // farent)