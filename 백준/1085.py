x, y, w, h = map(int,input().split())
rectangle_len = []
rectangle_len.append(w-x)
rectangle_len.append(h-y)
rectangle_len.append(x)
rectangle_len.append(y)
print(min(rectangle_len))
