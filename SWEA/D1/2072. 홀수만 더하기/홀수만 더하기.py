T = int(input())

for test_case in range(1, T + 1):
    num_list = list(map(int, input().split()))
    result = 0
    for i in num_list:
        if i % 2 != 0:
            result += i
    print(f"#{test_case} {result}")