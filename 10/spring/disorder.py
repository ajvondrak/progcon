import sys

def distance(list):
    dict = sorted(list)
    lex = sorted(list, cmp=lambda w1, w2: cmp(len(w1), len(w2)) or cmp(w1, w2))
    return sum(abs(dict.index(w) - lex.index(w)) for w in list)

for list in (l.split() for l in sys.stdin.read().split('\n\n')[:-1]):
    print distance(list)
