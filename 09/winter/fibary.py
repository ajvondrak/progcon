def fibs(n):
    a = 1
    b = 1
    while b <= n:
        a, b = b, b+a
        yield a

while True:
    try: decimal = int(raw_input())
    except: break
    if decimal == 0:
        print "0"
        continue
    canonical = ""
    for i in reversed(list(fibs(decimal))):
        #print "\t", i, decimal
        if i <= decimal:
            canonical += "1"
            decimal -= i
        else: canonical += "0"
    print canonical
