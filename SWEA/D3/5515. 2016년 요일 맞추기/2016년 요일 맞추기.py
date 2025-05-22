from collections import deque

T = int(input())
for tc in range(1, T + 1):
    m, d = map(int, input().split())
    final_d = {1:31, 2:29, 3:31, 4:30, 5:31, 6:30,
               7:31, 8:31, 9:30, 10:31, 11:30, 12:31}
    queue = deque()
    queue.append([1, 1])
    d_dict = {0:4, 1:3, 2:2, 3:1, 4:0, 5:6, 6:5}
    while True:
        now = queue.popleft()
        now_m, now_d = now[0], now[1]
        if now_m > m or (now_m == m and now_d >= d):
            if now_m > m:
                now_d += final_d[now_m - 1]
            print(f"#{tc} {d_dict[now_d - d]}")
            break
        now_d += 7
        if now_d > final_d[now_m]:
            now_d -= final_d[now_m]
            now_m += 1
        queue.append([now_m, now_d])

