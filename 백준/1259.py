palin_check_list = []
while True:
    palindrome = input()
    if int(palindrome) == 0:
        break
    palin_check = ''
    for i in range(len(palindrome)-1, -1, -1):
        palin_check += palindrome[i]
    if palin_check == palindrome:
        palin_check_list.append("yes")
    else:
        palin_check_list.append("no")
for k in range(len(palin_check_list)):
    print(palin_check_list[k])
