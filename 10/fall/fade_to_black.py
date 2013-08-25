import sys, math

def triplet(xyz):
    return xyz[:2], xyz[2:4], xyz[4:]

def euclidean_distance(rgb):
    r, g, b = triplet(rgb)
    return math.sqrt(int(r, 16)**2 + int(g, 16)**2 + int(b, 16)**2)

def compare(rgb1, rgb2):
    e1, e2 = euclidean_distance(rgb1), euclidean_distance(rgb2)
    if e1 == e2:
        return cmp(rgb2, rgb1) # reverse = True
    return cmp(e1, e2)

colors = [x.strip() for x in sys.stdin.readlines()]
colors.sort(cmp=compare, reverse=True)
print "\n".join(colors)
