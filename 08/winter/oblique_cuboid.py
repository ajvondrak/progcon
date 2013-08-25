line = raw_input()
while line:
    w, h, d = map(int, line.split())
    points = [(i, 0, 0) for i in range(h+1)] +\
             [(i, w, 0) for i in range(h+1)] +\
             [(i, w, d) for i in range(h+1)] +\
             [(i, 0, d) for i in range(h+1)] +\
             [(0, i, 0) for i in range(w+1)] +\
             [(0, i, d) for i in range(w+1)] +\
             [(h, i, 0) for i in range(w+1)] +\
             [(h, i, d) for i in range(w+1)] +\
             [(0, w, i) for i in range(d+1)] +\
             [(0, 0, i) for i in range(d+1)] +\
             [(h, w, i) for i in range(d+1)] +\
             [(h, 0, i) for i in range(d+1)]
    #print h, w, d
    new_points = [(x+z, y+z) for (x,y,z) in points]
    max_x = max([x for (x,y) in new_points]) + 1
    max_y = max([y for (x,y) in new_points]) + 1
    #print sorted(new_points)
    #print new_points, max_x, max_y
    for j in range(max_y, -1, -1):
        s = ""
        for i in range(max_x):
            if (i,j) in new_points:
                s += "*"
            else:
                s += " "
        print s
    try: line = raw_input()
    except: break
        
