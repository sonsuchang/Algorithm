from collections import Counter
import math

def solution(str1, str2):
    str1 = str1.lower()
    str2 = str2.lower()
    A = []
    B = []
    lengthA = len(str1) - 1
    lengthB = len(str2) - 1
    for i in range(lengthA):
        if (str1[i] + str1[i + 1]).isalpha():
            A.append(str1[i] + str1[i + 1])
    for i in range(lengthB):
        if (str2[i] + str2[i + 1]).isalpha():
            B.append(str2[i] + str2[i + 1])
    if len(A) == 0 and len(B) == 0:
        return 65536
    countA = Counter(A)
    countB = Counter(B)
    crossValue = 0
    appendValue = 0
    for i in countA.keys():
        if i in countB.keys():
            crossValue += min(countA[i], countB[i])
            appendValue += max(countA[i], countB[i])
        else:
            appendValue += countA[i]
    for i in countB.keys():
        if i not in countA.keys():
            appendValue += countB[i]
    return math.floor(crossValue / appendValue * 65536)