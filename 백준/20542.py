n, m = map(int, input().split())
fiword = list(input())
seword = list(input())
count = 0
if len(fiword) > len(seword):
    for i in range(len(seword)):
        indexcount = 0
        for k in fiword:
            if seword[i] == k:
                fiword[indexcount] = '0'
                print(fiword)
                count += 1
                break
            else:
                indexcount += 1
elif len(fiword) < len(seword):
    for i in range(len(fiword)):
        indexcount = 0
        for k in seword:
            if fiword[i] == k:
                seword[indexcount] = '0'
                count += 1
                break
            else:
                indexcount += 1
elif len(fiword) == len(seword):
    for i in range(len(seword)):
        indexcount = 0
        for k in fiword:
            if seword[i] == k:
                fiword[indexcount] = '0'
                count += 1
                break
            else:
                indexcount += 1
print(count)
