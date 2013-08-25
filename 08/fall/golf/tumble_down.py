from sys import stdin 

def left_supports((ax, ay, aw, ah), (bx, by, bw, bh)):
    return by == ay + ah and bx < ax + aw and bx + bw/2.0 > ax

def right_supports((ax, ay, aw, ah), (bx, by, bw, bh)):
    return by == ay + ah and bx + bw > ax and bx + bw/2.0 < ax + aw

def find_supported(blocks):
    supported, to_add = set(), set(b for b in blocks if b[1] == 0)
    while to_add:
        supported = supported.union(to_add)
        to_add = set()
        for b in set(blocks) - supported:
            for a_l in supported:
                for a_r in supported:
                    if left_supports(a_l, b) and right_supports(a_r, b):
                        to_add.add(b)
    return list(supported)

blocks = [tuple(map(int, block.split())) for block in stdin.readlines()]
supported = find_supported(blocks)
for i, b in enumerate(blocks):
    print "block %d is%s supported" % (i+1, "" if b in supported else " not")
