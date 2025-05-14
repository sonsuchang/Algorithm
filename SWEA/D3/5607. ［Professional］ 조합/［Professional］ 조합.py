T = int(input())
MOD = 1234567891
for tc in range(1, T + 1):
    N, R = map(int, input().split())
    fact = [1] * (N + 1)
    for i in range(1, N + 1):
        fact[i] = (fact[i - 1] * i) % MOD
    parent = (fact[R] * fact[N - R]) % MOD
    answer = (fact[N] * (pow(parent, MOD - 2, MOD))) % MOD
    print(f"#{tc} {answer}")