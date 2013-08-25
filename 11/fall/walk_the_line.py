import sys
from math import factorial as f

for line in sys.stdin:
    n, d = map(int, line.split())
    if n%2 == d%2:
        # n choose (n+d)/2
        nwalks = f(n) / (f((n+d)/2) * f(n-(n+d)/2))
        print "%d %d-step walks end at %d" % (nwalks, n, d)
    else:
        print "0 %d-step walks end at %d" % (n, d)
