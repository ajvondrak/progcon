from sys import stdin 
from string import punctuation, ascii_letters

def huffman_codes(node, code='', codes=set()):
    if node is None: return
    ch, freq, left, right = node
    if len(ch) == 1: codes.add((ch, code, freq))
    huffman_codes(left, code+'0')
    huffman_codes(right, code+'1')
    return codes

def compare_trees(t1, t2):
    c1, c2 = min(t1[0]), min(t2[0])
    w1, w2 = t1[1], t2[1]
    if w1 == w2:
        return cmp(c1, c2)
    return cmp(w1, w2)

def generate_huffman_tree():
    freqs = {}
    for c in stdin.read():
        if c in punctuation + " " or c in ascii_letters:
            if c not in freqs: freqs[c] = 0
            freqs[c] += 1
    trees = set([(c, freq, None, None) for (c, freq) in freqs.iteritems()])
    while len(trees) > 1:
        sort = sorted(trees, cmp=compare_trees)
        t1, t2 = sort[0], sort[1]
        trees.remove(t1)
        trees.remove(t2)
        t = (t1[0] + t2[0], t1[1] + t2[1], t1, t2)
        trees.add(t)
    return list(trees)[0]

if __name__ == '__main__':
    tr = generate_huffman_tree()
    for code in sorted(huffman_codes(tr), cmp=lambda x, y: cmp(x[1], y[1])):
        print '%s %s (%d)' % code
