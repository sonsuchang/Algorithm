T = int(input())
output = []
for i in range(1, T + 1):
    target = str(i)
    if "3" in target or "6" in target or "9" in target:
        num = target.count("3") + target.count("6") + target.count("9")
        output.append("-" * num)
    else:
        output.append(i)
print(*output)