T = int(input())
for tc in range(1, T + 1):
    N = input()
    N_list = list(N)
    answer = set()
    answer.add(int(N))
    length = len(N_list)
    for i in range(length):
        for j in range(i + 1, length):
            N_list[i], N_list[j] = N_list[j], N_list[i]
            if N_list[0] != "0":
                answer.add(int(''.join(N_list)))
            N_list[j], N_list[i] = N_list[i], N_list[j]
    print(f"#{tc} {min(answer)} {max(answer)}")