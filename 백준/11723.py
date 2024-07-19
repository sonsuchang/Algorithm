import sys
S = set()
all_s = [str(i) for i in range(1,21)]
for _ in range(int(sys.stdin.readline())):
    temp = list(sys.stdin.readline().split())
    if len(temp) == 1:
        if temp[0] == "all":
            S = set(all_s)
        elif temp[0] == "empty":
            S = set()
    else:
        if temp[0] == "add":
            if temp[1] not in S:
                S.add(temp[1])
            else:
                continue
        elif temp[0] == "remove":
            if temp[1] in S:
                S.remove(temp[1])
            else:
                continue
        elif temp[0] == "check":
            if temp[1] in S:
                print(1)
            else:
                print(0)
        elif temp[0] == "toggle":
            if temp[1] in S:
                S.remove(temp[1])
            else:
                S.add(temp[1])