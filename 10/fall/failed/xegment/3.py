while True:
    try: x, y = map(int, raw_input().split())
    except: break
    if x == y: print "%d pixels" % x # wlog
    else: print "%d pixels" % (x - 1 + y)
