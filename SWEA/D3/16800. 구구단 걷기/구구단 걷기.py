import math

def gcd(num):
    length = int(math.sqrt(num))
    for i in range(length, 1, - 1):
        if num % i == 0:
            if i == num // i:
                return 2 * (i - 1)
            else:
                return (i - 1) + (num // i - 1)
    return num - 1

T = int(input())
for tc in range(1, T + 1):
    N = int(input())
    print(f"#{tc} {gcd(N)}")