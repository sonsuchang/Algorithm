lst1 = [1]
lst2 = [1,2]
lst3 = [1,2,3]
lst4 = [1,2,3,4]
lst5 = [1,2,3,4,5]
lst6 = [1,2,3,4,5,6]
lst7 = [1,2,3,4,5,6,7]
lst8 = [1,2,3,4,5,6,7,8]
lst9 = [1,2,3,4,5,6,7,8,9]
lst10 = [1,2,3,4,5,6,7,8,9,10]
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
lin_search(lst1, 4)
lin_search(lst2, 4)
lin_search(lst3, 4)
lin_search(lst4, 4)
lin_search(lst5, 4)
lin_search(lst6, 4)
lin_search(lst7, 4)
lin_search(lst8, 4)
lin_search(lst9, 4)
lin_search(lst10, 4)

