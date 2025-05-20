import math

T = int(input())
for tc in range(1, T + 1):
    N, D, G = map(int, input().split())
    answer = "Possible"
    if G == 100 and D != 100:
        answer = "Broken"
    elif G == 0 and D != 0:
        answer = "Broken"
    val = math.gcd(D, 100)
    min_game = 100 // val
    if min_game > N:
        answer = "Broken"
    print(f"#{tc} {answer}")