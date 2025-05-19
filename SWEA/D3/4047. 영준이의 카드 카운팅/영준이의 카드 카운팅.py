T = int(input())
for tc in range(1, T + 1):
    S = list(input().rstrip())
    deck = {"S" : [], "D" : [], "H" : [], "C" : []}
    answer = True
    for i in range(0, len(S), 3):
        if (S[i + 1] + S[i + 2]) in deck[S[i]]:
            answer = False
            break
        else:
            deck[S[i]].append(S[i + 1] + S[i + 2])
    if answer:
        print(f"#{tc} {13 - len(deck['S'])} {13 - len(deck['D'])} {13 - len(deck['H'])} {13 - len(deck['C'])}")
    else:
        print(f"#{tc} ERROR")