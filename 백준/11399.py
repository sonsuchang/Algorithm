people = int(input())
timelist = input().split()
callist = []
for i in range(people):
  callist.append(int(timelist[i]))
callist.sort()
def recursivefunc(cali, ind):
  if ind == people - 1:
    cali[ind] = cali[ind - 1] + cali[ind]
    return cali
  else:
    cali[ind] = cali[ind - 1] + cali[ind]
    recursivefunc(cali, ind + 1)
recursivefunc(callist, 1)
sum = 0
for k in range(people):
  sum += callist[k]
print(sum)
