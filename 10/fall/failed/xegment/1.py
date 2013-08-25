import math
while True:
    try: x, y = map(int, raw_input().split())
    except: break
    print "%d" % max(math.ceil(1.0 * x / y) * y, math.ceil(1.0 * y / x) * x), "pixels"
