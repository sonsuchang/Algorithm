import sys

T = int(sys.stdin.readline())
for _ in range(T):
    S = sys.stdin.readline().strip()
    print(S[0] + S[-1])