def check(num):
    if num == 1:
        return True
    for i in range(9, 1, -1):
        if num % i == 0:
            num = num // i
            if num <= 9:
                return True
            else:
                return False
    return False

T = int(input())
for tc in range(1, T + 1):
    N = int(input())
    if check(N):
        print(f"#{tc} Yes")
    else:
        print(f"#{tc} No")