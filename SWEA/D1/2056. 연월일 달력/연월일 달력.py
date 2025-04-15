T = int(input())
for test_case in range(1, T + 1):
    month_dict = {1:31, 2:28, 3:31, 4:30, 5:31, 6:30, 7:31, 8:31, 9:30, 10:31, 11:30, 12:31}
    target = input()
    if 1 <= int(target[4:6]) <= 12 and 1 <= int(target[6:]) <= month_dict[int(target[4:6])]:
        result = target[:4] + "/" + target[4:6] + "/" + target[6:]
        print(f"#{test_case} {result}")
    else:
        print(f"#{test_case} -1")