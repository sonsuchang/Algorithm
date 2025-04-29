T = int(input())
for test_case in range(1, T + 1):
    N, K = map(int, input().split())
    grade = ["A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"]
    grade_range = N // 10
    user = {}
    for i in range(1, N + 1):
        temp = list(map(int, input().split()))
        user[i] = round(temp[0] * 0.35 + temp[1] * 0.45 + temp[2] * 0.2)
    user_list = sorted(user.items(), key = lambda x : x[1], reverse = True)
    for i in range(N):
        if user_list[i][0] == K:
            print(f"#{test_case} {grade[i // grade_range]}")