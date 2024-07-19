import sys

N, M = map(int, sys.stdin.readline().split())

parent = [i for i in range(N)]

def find(x):
    if x == parent[x]:
        return x
    parent[x] = find(parent[x])
    return parent[x]

def union(x, y):
    x = find(x)
    y = find(y)

    if y < x:
        parent[x] = y
    else:
        parent[y] = x

for i in range(M):
    node1, node2 = map(int, sys.stdin.readline().split())
    if find(node1) == find(node2):
        print(i + 1)
        exit(0)
    union(node1, node2)
print(0)