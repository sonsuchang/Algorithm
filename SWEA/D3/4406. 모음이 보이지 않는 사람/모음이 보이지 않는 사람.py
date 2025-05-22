T = int(input())
for tc in range(1, T + 1):
    S = input().rstrip()
    result = ""
    n = ["a", "e", "i", "o", "u"]
    for i in range(len(S)):
        if S[i] not in n:
            result += S[i]
    print(f"#{tc} {result}")