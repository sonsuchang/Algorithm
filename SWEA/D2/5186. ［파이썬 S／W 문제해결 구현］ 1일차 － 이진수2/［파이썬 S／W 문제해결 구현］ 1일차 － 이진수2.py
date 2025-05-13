T = int(input())
for tc in range(1, T + 1):
    N = float(input())
    N_list = [2 ** -i for i in range(1, 13)]
    answer = ""
    for i in N_list:
        if N == 0:
            break
        if N - i >= 0:
            N -= i
            answer += "1"
        else:
            answer += "0"
    if N == 0:
        print(f"#{tc} {answer}")
    else:
        print(f"#{tc} overflow")