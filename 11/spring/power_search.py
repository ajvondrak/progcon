import sys
for line in sys.stdin.readlines():
    a, b = map(int, line.split())
    i = 0
    while not (a <= b**i < a * b):
        i += 1
    print "%d <= %d^%d = %d < %d*%d = %d" % (a, b, i, b**i, a, b, a * b)
