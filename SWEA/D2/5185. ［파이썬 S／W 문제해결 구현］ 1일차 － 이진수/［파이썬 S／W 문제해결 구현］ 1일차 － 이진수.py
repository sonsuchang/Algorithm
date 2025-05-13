T = int(input())
for tc in range(1, T + 1):
    N = input().split()
    target = N[1]
    answer = ""
    target_dict = {"A" : 10, "B" : 11, "C" : 12, "D" : 13, "E" : 14, "F" : 15}
    for i in target:
        num = i
        if i in target_dict.keys():
            num = target_dict[i]
        else:
            num = int(i)
        change = bin(num)[2:]
        if len(change) == 4:
            answer += change
        else:
            answer += ((4 - len(change)) * "0" + change)
    print(f"#{tc} {answer}")