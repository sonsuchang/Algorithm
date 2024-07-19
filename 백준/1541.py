math_sentence = input().split('-')
num_list = []
for i in math_sentence:
    if "+" in i:
        temp = i.split("+")
        sum = 0
        for k in temp:
            sum += int(k)
        num_list.append(sum)
    else:
        num_list.append(int(i))
result = num_list[0]
for j in range(1, len(num_list)):
    result -= num_list[j]
print(result)