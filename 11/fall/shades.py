import sys

ws = range(10)
opaque_shades      = {w:0 for w in ws}
translucent_shades = {w:0 for w in ws}

def percentage():
    total = 1000 
    for w in ws:
        if opaque_shades[w] >= translucent_shades[w]:
            total -= opaque_shades[w]
        else:
            total -= 0.5*(opaque_shades[w] + translucent_shades[w])
    return round(total/10.)

for line in sys.stdin:
    w, translucent, p = line.split()
    translucent = (translucent=='translucent')
    w = int(w)
    p = int(p)

    if translucent: translucent_shades[w] = p
    else: opaque_shades[w] = p

    print "%d" % percentage()
