import sys

temp_str = sys.stdin.readline().strip()
temp_list = []
for i in range(len(temp_str)):
    if 65 <= ord(temp_str[i]) <= 90:
        temp_list.append(chr(ord(temp_str[i]) + 32))
    else:
        temp_list.append(chr(ord(temp_str[i]) - 32))

print(''.join(temp_list))