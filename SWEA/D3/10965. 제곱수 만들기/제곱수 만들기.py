import math

MAX = 3163
is_prime = [True] * MAX
primes = []

def sieve():
    is_prime[0] = is_prime[1] = False
    for i in range(2, MAX):
        if is_prime[i]:
            primes.append(i)
            for j in range(i*i, MAX, i):
                is_prime[j] = False

sieve()
answer = []
T = int(input())
for tc in range(1, T + 1):
    N = int(input())
    B = 1
    length = int(math.sqrt(N)) + 1
    for i in range(2, length):
        count = 0
        while N % i == 0:
            N //= i
            count += 1
        if count % 2 == 1:
            B *= i
    if N > 1:
        B *= N
    answer.append(B)
for tc in range(T):
    print(f"#{tc + 1} {answer[tc]}")