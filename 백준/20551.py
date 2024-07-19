inputarray = []
outputarray = []
lilen, qnum = map(int, input().split())
for i in range(lilen):
    inputnum = int(input())
    inputarray.append(inputnum)
for s in range(len(inputarray)):
    for u in range(s, len(inputarray)):
        if inputarray[s] > inputarray[u]:
            temp = inputarray[s]
            inputarray[s] = inputarray[u]
            inputarray[u] = temp
for k in range(qnum):
    q = int(input())
    for j in range(len(inputarray)):
        if inputarray[j] == q:
            outputarray.append(j)
            break
        elif j == 4 and inputarray[j] != q:
            outputarray.append(-1)
for z in outputarray:
    print(z)
