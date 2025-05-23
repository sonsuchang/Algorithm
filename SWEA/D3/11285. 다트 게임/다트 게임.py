import math

T = int(input())

num = []
for i in range(20, 201, 20):
    num.append(i)

output = []
for tc in range(1, T + 1):
    N = int(input())
    answer = 0
    for _ in range(N):
        x, y = map(int, input().split())
        dis = math.sqrt(x ** 2 + y ** 2)
        for i in range(10):
            if dis <= num[i]:
                answer += (10 - i)
                break
    output.append(answer)

for i in range(1, T + 1):
    print(f"#{i} {output[i - 1]}")