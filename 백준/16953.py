import sys

A, B = map(int, sys.stdin.readline().split())
break_cnt = 0
def BFS(x, y, cnt):
    global break_cnt
    if x == y:
        print(cnt)
        break_cnt += 1
    if x < y:
        BFS(x * 2, y, cnt + 1)
        BFS(int(str(x) + '1'), y, cnt + 1)
BFS(A, B, 1)
if break_cnt == 0:
    print(-1)