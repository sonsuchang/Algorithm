N = int(input())
first = 666
cnt = 1
while True:
    if cnt == N:
        break
    first += 1
    if '666' in str(first):
        cnt += 1
print(first)
