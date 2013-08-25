#def pick(subword, word):
#    if not subword:
#        return 1
#    if not word:
#        return 0
#    indices = (i for (i, ch) in enumerate(word) if ch == subword[0])
#    # eek, stack space.  will this be a problem, or should I do it bottom-up?
#    return sum(pick(subword[1:], word[i+1:]) for i in indices)

def pick(subword, word):
    if not subword:
        return 1
    if len(subword) > len(word):
        return 0
    indices = (i for (i, ch) in enumerate(word) if ch == subword[0])
    return sum(pick(subword[1:], word[i+1:]) for i in indices)

#from collections import defaultdict
#
#def vpick(subword, word, n=0):
#    if not subword:
#        print '   '*n, '1'
#        return 1
#    if len(subword) > len(word):
#        print '   '*n, '0'
#        return 0
#    indices = (i for (i, ch) in enumerate(word) if ch == subword[0])
#    s = 0
#    for i in indices:
#        print '   '*n, 'subword =', repr(subword[1:]), 'word =', repr(word[i+1:]), '==>'
#        s += pick(subword[1:], word[i+1:], n+1)
#    return s
#
#def indices(x, seq, start=0):
#    return (i+start for (i, y) in enumerate(seq[start:]) if y == x)
#
#def cob_pick(subword, word):
#    s = 0
#    for i in indices(subword[0], word):
#        for j in indices(subword[1], word, i+1):
#            s += word.count(subword[2], j+1)
#    return s

while True:
    try:
        subword, word = raw_input().split()
    except:
        break
    print '%d "%s" in "%s"' % (pick(subword, word), subword, word)
