import sys

r = sys.stdin.readline
inventory = {int(i,8):int(p) for i, p in [r().split() for _ in range(int(r()))]}

nitems = 0
cost = 0

for line in sys.stdin:
    q, barcode = line.split()
    q = int(q)
    barcode = int(barcode, 2)
    if barcode not in inventory:
        print "item %o not in inventory" % barcode
    else:
        nitems += q
        cost += q * inventory[barcode]

print "deliver %d items from inventory, total cost = $%d" % (nitems, cost)
