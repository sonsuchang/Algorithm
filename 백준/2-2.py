S = set()
a = 0
b = 0
S.add((a,b))
def Set_S(n):
    global a
    global b
    if n == 0:
        return S
    y = b + 1
    b = y
    S.add((a,y))
    x = a + 1
    a = x
    S.add((x,y))
    return Set_S(n-1)
print(Set_S(2))

'''
def factorial(n):
    if n == 1:
        return 1
    return n * factorial(n - 1)
print(factorial(3))
'''
