def solution(n, t, m, p):
    answer = ''
    numDict = {0 : "0", 1 : "1", 2 : "2", 3 : "3", 4 : "4", 5 : "5",
               6 : "6", 7 : "7", 8 : "8", 9 : "9", 10 : "A",
               11 : "B", 12 : "C", 13 : "D", 14 : "E", 15 : "F"}
    numList = ["0"]
    num = 1
    exp = 1
    while len(numList) < t * m:
        temp = ""
        if (n ** exp) - 1 < num:
            exp += 1
        numtemp = num
        for i in range(exp - 1, -1, -1):
            temp += numDict[numtemp // (n ** i)]
            numtemp = numtemp % (n ** i)
        num += 1
        numList += list(temp)
    for i in range(t):
        answer += numList[p - 1]
        p += m
    return answer