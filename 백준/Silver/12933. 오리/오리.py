import sys
input = sys.stdin.readline

sound = input().strip()
n = len(sound)

if n % 5 != 0:
    print(-1)
    exit()

target = "quack"
duck_count = 0
active_ducks = [0] * 2500

for char in sound:
    found = False

    for i in range(duck_count):
        if target[active_ducks[i]] == char:
            active_ducks[i] += 1
            if active_ducks[i] == 5:
                active_ducks[i] = 0
            found = True
            break

    if not found:
        if char == "q":
            active_ducks[duck_count] = 1
            duck_count += 1
        else:
            print(-1)
            exit()

if any(active_ducks[i] != 0 for i in range(duck_count)):
    print(-1)
else:
    print(duck_count)