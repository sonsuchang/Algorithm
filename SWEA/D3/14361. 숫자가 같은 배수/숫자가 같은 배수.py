from itertools import permutations

T = int(input())

for tc in range(1, T + 1):
    N = list(input().rstrip())
    case = []
    for i in permutations(N, len(N)):
        case.append(int(''.join(i)))
    target = int(''.join(N))
    answer = "impossible"
    for i in range(2, 10):
        if target * i in case:
            answer = "possible"
            break
    print(f"#{tc} {answer}")