import sys

input = sys.stdin.readline

N = int(input())
answer = 0

buildings = []
for i in range(N):
    building = int(input())

    if len(buildings) == 0:
        buildings.append(building)
        continue

    while buildings and buildings[-1] <= building:
        buildings.pop()

    answer += len(buildings)
    buildings.append(building)
    
print(answer)