def solution(schedules, timelogs, startday):
    answer = 0
    idx_dict = {
        1 : [0, 1, 2, 3, 4],
        2 : [0, 1, 2, 3, 6],
        3 : [0, 1, 2, 5, 6],
        4 : [0, 1, 4, 5, 6],
        5 : [0, 3, 4, 5, 6],
        6 : [2, 3, 4, 5, 6],
        7 : [1, 2, 3, 4, 5]}
    check_idx = idx_dict[startday]
    
    n_list = [] # N명의 인정 가능한 출근시간
    
    for i in schedules:
        temp = str(i + 10)
        hour = temp[:len(temp) // 4 + 1]
        minute = temp[-2:]
        if int(minute) >= 60:
            minute = "0" + str(int(minute) - 60)
            hour = str(int(hour) + 1)
            n_list.append(int(hour + minute))
        else:
            n_list.append(int(temp))

    length = len(n_list)
    for i in range(length):
        cnt = 0
        for j in check_idx:
            if n_list[i] < timelogs[i][j]:
                break
            cnt += 1
        if cnt == 5:
            answer += 1
    return answer