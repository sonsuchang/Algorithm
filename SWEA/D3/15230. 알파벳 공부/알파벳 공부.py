T = int(input())
for tc in range(1, T + 1):
    alpha = [chr(i) for i in range(97, 123)]
    s = input().rstrip()
    answer = 0
    for i in range(len(s)):
        if s[i] != alpha[i]:
            break
        answer += 1
    print(f"#{tc} {answer}")
