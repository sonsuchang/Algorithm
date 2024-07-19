import sys
N, M, V = map(int, sys.stdin.readline().split())
search_dict = {}

for i in range(1, N + 1):
    search_dict[i] = []
for _ in range(M):
    M_f, M_s = map(int, sys.stdin.readline().split())
    search_dict[M_f].append(M_s)
    search_dict[M_s].append(M_f)
    search_dict[M_f].sort()
    search_dict[M_s].sort()

visited_dfs = []
def search_dfs(search_dict, V, visited_dfs):
    visited_dfs.append(V)
    for i in search_dict[V]:
        if i not in visited_dfs:
            search_dfs(search_dict, i, visited_dfs)
search_dfs(search_dict, V, visited_dfs)
print(*visited_dfs)

visited_bfs = []
def search_bfs(search_dict, V, visited_bfs):
    visited_bfs.append(V)
    temp = []
    temp.append(V)
    while temp:
        k = temp.pop(0)
        for i in search_dict[k]:
            if i not in visited_bfs:
                temp.append(i)
                visited_bfs.append(i)
search_bfs(search_dict, V, visited_bfs)
print(*visited_bfs)