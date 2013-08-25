from sys import stdin 

ascii = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~"

def codes((ch, freq, left, right), code='', huffman_codes=set()):
    if len(ch) == 1: huffman_codes.add((ch, code, freq))
    if left is not None: codes(left, code+'0')
    if right is not None: codes(right, code+'1')
    return huffman_codes

def cmp_trees(t1, t2): return cmp(t1[1], t2[1]) or cmp(min(t1[0]), min(t2[0]))

data = stdin.read()
trees = set((c, data.count(c), None, None) for c in data if c in ascii)
while len(trees) > 1:
    sort = sorted(trees, cmp=cmp_trees)
    t1, t2 = sort[0], sort[1]
    trees.remove(t1)
    trees.remove(t2)
    t = (t1[0] + t2[0], t1[1] + t2[1], t1, t2)
    trees.add(t)
tr = list(trees)[0]
for code in sorted(codes(tr), key=lambda x: x[1]): print '%s %s (%d)' % code
