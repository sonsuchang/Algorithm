import sys
sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

def find(parents, x):
    if parents[x] == x:
        return x

    parents[x] = find(parents, parents[x])
    return parents[x]

def union(parents, a, b):
    a = find(parents, a)
    b = find(parents, b)

    if a > b:
        parents[a] = b
    else:
        parents[b] = a

def is_connected(parents, cities):
    pre = find(parents, cities[0])

    for city in cities[1:]:
        cur = find(parents, city)
        if pre != cur:
            return "NO"
        pre = cur

    return "YES"

def main():
    n = int(input())
    m = int(input())
    maps = [list(map(int, input().rstrip().split())) for _ in range(n)]
    cities = list(map(lambda x: int(x) - 1, input().rstrip().split()))

    parents = [i for i in range(n)]
    for i in range(n):
        for j in range(n):
            if maps[i][j] == 1:
                union(parents, i, j)
    print(is_connected(parents, cities))

main()