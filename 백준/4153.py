check_list = []
while True:
    temp = list(map(int, input().split()))
    if temp == [0, 0, 0]:
        break
    c = max(temp)
    temp.remove(c)
    if c ** 2 == temp[0] ** 2 + temp[1] ** 2:
        check_list.append("right")
    else:
        check_list.append("wrong")
for i in range(len(check_list)):
    print(check_list[i])
 
