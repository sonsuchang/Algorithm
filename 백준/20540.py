mbtilist = [['E','I'], ['S', 'N'], ['T', 'F'], ['J', 'P']]
mbtioutput = []
mbtiinput = input()
mbtiinput = list(mbtiinput)
for i in range(len(mbtiinput)):
    for k in range(2):
        #print(mbtilist[i][k])
        if mbtilist[i][k] == mbtiinput[i]:
            if k == 0:
                k = 1
                mbtioutput.append(mbtilist[i][k])
            elif k == 1:
                k = 0
                mbtioutput.append(mbtilist[i][k])
print(''.join(mbtioutput))
