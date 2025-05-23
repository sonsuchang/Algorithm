T = int(input())
output = []
for _ in range(T):
    N = int(input())
    N_list = [list(map(int, input().split())) for _ in range(N)]
    cnt = 0
    for i in range(N):
        select_x, select_y = N_list[i][0], N_list[i][1]
        for j in range(i, N):
            nx, ny = N_list[j][0], N_list[j][1]
            if (select_x < nx and select_y > ny) or (select_x > nx and select_y < ny):
                cnt += 1
    output.append(cnt)

for tc in range(1, T + 1):
    print(f"#{tc} {output[tc - 1]}")