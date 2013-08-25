while True:
    try: x, y = map(int, raw_input().split())
    except: break
    m = 1.0 * x / y
    mx = 0
    overlap = 0
    for yc in xrange(y):
        mx += m
        if mx % 1 != 0 and mx <= x:
            overlap += 1
    print "%d pixels" % (x + overlap)
