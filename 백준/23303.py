s = input()
if s.find('d') == -1 or s.find('D') == -1:
    print("unrated")
elif s[s.find('d') + 1] == 2 or s[s.find('D') + 1] == 2:
    print("D2")
