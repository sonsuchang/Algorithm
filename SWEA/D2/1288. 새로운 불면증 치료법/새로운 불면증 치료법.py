T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    number = set()
    i = 1
    result = 0
    while True:
        target = str(N * i)
        length = len(target)
        for j in range(length):
            number.add(target[j])
        i += 1
        if len(number) == 10:
            result = int(target)
            break
    print(f"#{test_case} {target}")