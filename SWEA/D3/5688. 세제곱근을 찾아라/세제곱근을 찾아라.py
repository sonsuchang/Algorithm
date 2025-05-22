import math

num_list = []
for i in range(1, 1000001):
    num_list.append(i ** 3)

T = int(input())
for tc in range(1, T + 1):
    num = int(input())
    if num not in num_list:
        print(f"#{tc} -1")
    else:
        print(f"#{tc} {num_list.index(num) + 1}")