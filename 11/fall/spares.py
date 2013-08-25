import sys
from math import hypot, sqrt
from decimal import Decimal

inf = Decimal('inf')

def x((a, b)): return a
def y((a, b)): return b

def pi(j, k):
    #print "pi(", j, ",", k, ")"
    if y(j) >= y(k):
        return inf
    if x(j) == x(k):
        return Decimal(0)
    return Decimal(sqrt((x(k)-x(j))**2 + (y(k)-y(j))**2))

def min0(xs):
    ys = list(xs)
    if not ys:
        ret = 0
    else:
        ret = min(ys)
    #print "min0(", ys, ") =", ret
    return ret

def mu(xs):
    ys = list(xs) #!! important: don't use set() here
    if not ys:
        return Decimal(0)
    #if inf in ys:
    #    return inf
    ret = Decimal(sum(ys))/Decimal(len(ys))
    #print "mu(", ys, ") =", ret
    return ret

def delta(L):
    #print "delta(", L, ")"
    return min0(mu(min0(pi(j, k) for j in L if j!=k) for k in L if k!=i) for i in L)

def coords(L):
    for p in L:
        yield {1:(Decimal(0), Decimal(0)),
               2:(Decimal(-0.5), Decimal(sqrt(3)/2)),
               3:(Decimal(0.5), Decimal(sqrt(3)/2)),
               4:(Decimal(-1), Decimal(2*sqrt(3)/2)),
               5:(Decimal(0), Decimal(2*sqrt(3)/2)),
               6:(Decimal(1), Decimal(2*sqrt(3)/2)),
               7:(Decimal(-1.5), Decimal(3*sqrt(3)/2)),
               8:(Decimal(-0.5), Decimal(3*sqrt(3)/2)),
               9:(Decimal(0.5), Decimal(3*sqrt(3)/2)),
               10:(Decimal(1.5), Decimal(3*sqrt(3)/2))}[int(p)]

for line in sys.stdin:
    d = delta(list(coords(line.split())))
    if d == inf:
        print "spare difficulty is Infinity"
    else:
        print "spare difficulty is %.3f" % d
