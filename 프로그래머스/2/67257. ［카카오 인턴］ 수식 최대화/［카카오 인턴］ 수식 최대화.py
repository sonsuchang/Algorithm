from itertools import permutations
def solution(expression):
    def cal(expression, op):
        queue = []
        length = len(expression)
        digit = ""
        for j in range(length):
            if expression[j] in op:
                queue.append(digit)
                queue.append(expression[j])
                digit = ""
            else:
                digit += expression[j]
        queue.append(digit)
        for j in op:
            temp = []
            k = 0
            while k < len(queue):
                if queue[k] == j:
                    temp.append(str(eval(temp.pop() + j + queue[k + 1])))
                    k += 2
                else:
                    temp.append(queue[k])
                    k += 1
            queue = temp
        return abs(int(temp[0]))
    
    operations = ["*", "+", "-"]
    max_value = 0
    for operation in permutations(operations, 3):
        value = cal(expression, operation)
        if value > max_value:
            max_value = value
    return max_value