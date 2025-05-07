T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    value = 0
    for i in range(1, N + 1):
        if i % 2 == 0:
            value -= i
        else:
            value += i
    print(f"#{test_case} {value}")