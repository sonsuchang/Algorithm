n = int(input())
conference = {}
for _ in range(n):
    a, b = map(int, input().split())
    conference[a] = b
conference = sorted(conference.items())
print(conference)
