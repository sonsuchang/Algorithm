# '''
# rule
# 1. 좋아하는 학생과 가장 많이 인접한 곳에 앉는다.
# 2. 1에 해당하는 곳이 여러개라면 빈 칸과 인접한 곳이 가장 많은 곳에 앉는다.
# 3. 2에 해당하는 곳이 여러개라면 행 번호가 가장 작은 곳에 앉는다.
# 4. 3에 해당하는 곳이 여러개라면 열 번호가 가장 작은 곳에 앉는다.
# sol
# 1. 첫 학생은 N이 짝수일경우 (N // 2, N // 2) N이 홀수일경우 (N // 2 - 1, N // 2 - 1)
# '''
# import sys

# N = int(sys.stdin.readline())
# student_dict = {}
# class_room = [[0] * N for _ in range(N)]
# adjacent_dict = {}
# for i in range(1, N ** 2 + 1):
#     student_dict[i] = list(map(int, sys.stdin.readline().split()))
# if N % 2 == 0:
#     class_room[N // 2 - 1][N // 2 - 1] = student_dict[1][0]
# else:
#     class_room[N // 2][N // 2] = student_dict[1][0]
# student_dict = sorted(student_dict.items(), key = lambda x : x[0])

# def find_func(find_list):
    


# for i, j in student_dict:
#     if i == 1:
#         continue
#     find_func(j[1:])