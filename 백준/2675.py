test_case = int(input())
mul_num = []
mul_str = []
p = []
for _ in range(test_case):
    temp = input().split()
    mul_num.append(int(temp[0]))
    mul_str.append(temp[1])

cnt = 0
for i in mul_str:
    s = ''
    for k in range(len(i)):
        s += i[k] * mul_num[cnt]
    cnt += 1
    p.append(s)
for k in p:
    print(k)
