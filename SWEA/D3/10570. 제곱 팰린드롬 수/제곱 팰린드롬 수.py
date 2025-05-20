import math

def is_palindrome(n):
    s = str(n)
    return s == s[::-1]

T = int(input())
for tc in range(1, T + 1):
    A, B = map(int, input().split())
    
    start = math.ceil(math.sqrt(A))
    end = math.floor(math.sqrt(B))

    count = 0
    for i in range(start, end + 1):
        square = i * i
        if is_palindrome(i) and is_palindrome(square):
            count += 1

    print(f"#{tc} {count}")
