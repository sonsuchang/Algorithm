import sys
N, M = map(int, sys.stdin.readline().split())
pokemon_dict = {}
pokemon_num_dict = {}
for i in range(N):
    temp = input()
    pokemon_dict[temp] = i + 1
    pokemon_num_dict[i+1] = temp
for k in range(M):
    find_pokemon = sys.stdin.readline().rstrip()
    if find_pokemon in pokemon_dict.keys():
        print(pokemon_dict[find_pokemon])
    else:
        print(pokemon_num_dict[int(find_pokemon)])