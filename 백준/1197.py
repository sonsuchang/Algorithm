import sys

def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b):
    parent_a = find_parent(parent, a)
    parent_b = find_parent(parent, b)
    if parent_a < parent_b:
        parent[parent_b] = parent_a
    else:
        parent[parent_a] = parent_b

V, E = map(int, sys.stdin.readline().split())

parent = [0] * (V + 1)

for i in range(1, V + 1):
    parent[i] = i

edges = []
sum_edge = 0

for _ in range(E):
    edges.append(list(map(int, sys.stdin.readline().split())))

edges.sort(key = lambda x : x[2])
for first_node, second_node, cost in edges:
    if find_parent(parent, first_node) != find_parent(parent, second_node):
        union_parent(parent, first_node, second_node)
        sum_edge += cost

print(sum_edge)