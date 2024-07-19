s = list(input().upper())
solution = {}
for i in s:
    if i in solution.keys():
        solution[i] += 1
    else:
        solution[i] = 1
a = [k for k,v in solution.items() if v == max(solution.values())]
if len(a) == 1:
    print(a[0])
else:
    print("?")
