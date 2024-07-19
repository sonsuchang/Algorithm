import sys
N, M = map(int, sys.stdin.readline().split())
all_site = {}
print_list = []
for _ in range(N):
    site_name, site_password = input().split()
    all_site[site_name] = site_password
for i in range(M):
    find_password = input()
    print_list.append(all_site[find_password])
for j in range(len(print_list)):    
    print(print_list[j])