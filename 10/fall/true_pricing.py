while True:
    try: line = raw_input().split()
    except: break
    t, rs = int(line[0]), map(float, line[1:])
    b = t / (1 + sum(r/100 for r in rs))
    print "%.2f" % b
