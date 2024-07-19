import sys
T = int(sys.stdin.readline())
print_list = []
for _ in range(T):
    H, W, N = map(int, sys.stdin.readline().split())
    if N % H == 0:
        print_number = H * 100 + N // H
    else:
        print_number = 1
        print_number += N % H * 100
        print_number += N // H
    print_list.append(print_number)
for k in range(len(print_list)):
    print(print_list[k])
