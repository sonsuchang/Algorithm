import sys

N = int(sys.stdin.readline())
graph = {}
preorder = ''
inorder = ''
postorder = ''

for _ in range(N):
    temp = list(sys.stdin.readline().split())
    graph[temp[0]] = temp[1:]

def preorder_func(x):
    global preorder
    preorder += x
    if len(preorder) == N:
        return
    if graph[x][0] != '.':
        preorder_func(graph[x][0])
    if graph[x][1] != '.':
        preorder_func(graph[x][1])

def inorder_func(x):
    global inorder
    if len(inorder) == N:
        return
    if graph[x][0] != '.':
        inorder_func(graph[x][0])
    inorder += x
    if graph[x][1] != '.':
        inorder_func(graph[x][1])

def postorder_func(x):
    global postorder
    if len(postorder) == N:
        return
    if graph[x][0] != '.':
        postorder_func(graph[x][0])
    if graph[x][1] != '.':
        postorder_func(graph[x][1])
    postorder += x

preorder_func('A')
inorder_func('A')
postorder_func('A')

print(preorder)
print(inorder)
print(postorder)