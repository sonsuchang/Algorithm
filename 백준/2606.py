'''
import sys
computer_count = int(sys.stdin.readline())
direct_computer = int(sys.stdin.readline())
computer_dict = {}
virus = []
for i in range(direct_computer):
    com1, com2 = input().split()
    if com1 in computer_dict.keys():
        computer_dict[com1].append(com2)
        if com2 in computer_dict.keys():
            computer_dict[com2].append(com1)
        else:
            computer_dict[com2] = [com1]
    else:
        computer_dict[com1] = [com2]
        computer_dict[com2] = [com1]
def computer_dfs(computer_dict, start, virus):
    virus.append(start)
    if start in computer_dict.keys():
        for node in computer_dict[start]:
            if node not in virus:
                computer_dfs(computer_dict, node, virus)
    return virus
print(len(computer_dfs(computer_dict, '1', virus)) - 1)
'''
import sys
computer_count = int(sys.stdin.readline())
computer_connect = int(sys.stdin.readline())
graph = [[]*computer_count for _ in range(computer_count+1)]
for _ in range(computer_connect):
    com1, com2 = map(int, sys.stdin.readline().split())
    graph[com1].append(com2)
    graph[com2].append(com1)

virus = 0
visited = [0] * (computer_count + 1)
def computer_dfs(start):
    global virus
    visited[start] = 1
    for i in graph[start]:
        if visited[i] == 0:
            computer_dfs(i)
            virus += 1
computer_dfs(1)
print(virus)