from sys import stdin 

def top((x, y, w, h)): return y + h

def bottom((x, y, w, h)): return y

def left((x, y, w, h)): return x

def right((x, y, w, h)): return x + w

def center((x, y, w, h)): return x + w/2.0


def left_supports(a, b):
    return bottom(b) == top(a) and left(b) < right(a) and center(b) > left(a)

def right_supports(a, b):
    return bottom(b) == top(a) and right(b) > left(a) and center(b) < right(a)

def find_supported(blocks):
    supported = set()
    for b in blocks:
        if bottom(b) == 0:
            supported.add(b)
    changed = True
    while changed:
        to_add = set()
        changed = False
        for b in set(blocks) - supported:
            for a_l in supported:
                for a_r in supported:
                    if left_supports(a_l, b) and right_supports(a_r, b):
                        to_add.add(b)
                        changed = True
        supported = supported.union(to_add)
    return list(supported)

if __name__ == '__main__':
    blocks = [tuple(map(int, block.split())) for block in stdin.readlines()]
    supported = find_supported(blocks)
    for i, block in enumerate(blocks):
        if block in supported:
            print "block %d is supported" % (i+1)
        else:
            print "block %d is not supported" % (i + 1)
