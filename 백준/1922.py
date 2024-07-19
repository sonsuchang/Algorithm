import sys, heapq

N = int(sys.stdin.readline())
M = int(sys.stdin.readline())

graph = [[] for _ in range(N)]
for _ in range(M):
    A, B, cost = map(int, sys.stdin.readline().split())
    graph[A - 1].append((cost, B - 1))
    graph[B - 1].append((cost, A - 1))

# 프림 알고리즘을 사용한 최소 신장 트리(MST) 계산
def prim(start):
    visited = [False] * N
    min_heap = [(0, start)]  # (cost, node)
    total_cost = 0
    edge_count = 0

    while min_heap and edge_count < N:
        cost, node = heapq.heappop(min_heap)
        if not visited[node]:
            visited[node] = True
            total_cost += cost
            edge_count += 1
            for edge_cost, neighbor in graph[node]:
                if not visited[neighbor]:
                    heapq.heappush(min_heap, (edge_cost, neighbor))

    return total_cost

# 첫 번째 노드(0번 노드)를 시작점으로 MST를 계산
mst_cost = prim(0)
print(mst_cost)

# import sys

# N = int(sys.stdin.readline())
# M = int(sys.stdin.readline())

# edges = []
# for _ in range(M):
#     A, B, cost = map(int, sys.stdin.readline().split())
#     edges.append((cost, A - 1, B - 1))

# # 간선을 비용 순으로 정렬
# edges.sort()

# # 유니온-파인드 자료구조를 위한 함수들
# parent = list(range(N))
# rank = [0] * N

# def find(x):
#     if parent[x] != x:
#         parent[x] = find(parent[x])
#     return parent[x]

# def union(x, y):
#     rootX = find(x)
#     rootY = find(y)
#     if rootX != rootY:
#         if rank[rootX] > rank[rootY]:
#             parent[rootY] = rootX
#         elif rank[rootX] < rank[rootY]:
#             parent[rootX] = rootY
#         else:
#             parent[rootY] = rootX
#             rank[rootX] += 1

# # 크루스칼 알고리즘
# mst_cost = 0
# edge_count = 0

# for cost, A, B in edges:
#     if find(A) != find(B):
#         union(A, B)
#         mst_cost += cost
#         edge_count += 1
#         # 모든 노드를 연결했으면 종료
#         if edge_count == N - 1:
#             break

# print(mst_cost)
