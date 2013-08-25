def ceil_quot(a, b):
    quot = a / b
    if quot * b < a: return quot + 1
    return quot

while True:
    try: x, y = map(int, raw_input().split())
    except: break
    print "%d pixels" % max(ceil_quot(x, y) * y , ceil_quot(y, x) * x)
