import fractions
while True:
    try: x, y = map(int, raw_input().split())
    except: break
    print "%d pixels" % (x + y - fractions.gcd(x, y))

