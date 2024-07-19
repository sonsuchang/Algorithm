def lin_search(lst,x):
    loc = 0
    count = 0
    for i in range(len(lst)):
        count += 1
        if lst[i]==x:
            loc=i+1
            print("총 비교 횟수는 {}번이며, 해당 요소는 {}는(은) 주어진 리스트의{}번째에 있다." .format(count,x,loc))
    if loc == 0:
        print("총 비교 횟수는 {}번이며, 해당 요소는 {}는(은) 주어진 리스트에서 찾을 수 없다." .format(count, x))
lst = [2, 5, 9, 3, 4]
lin_search(lst, 4)
lin_search(lst, 7)
