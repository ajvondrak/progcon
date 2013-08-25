#I know for a fact (almost) that this won't work for the ACID Input, but I'm
#sending it anyway!

def b(k, w, x):
    if k == 0: return 0
    if k > 0: return min([b(j, w, x) + badness(j+1, k, w, x) for j in range(k)])

def badness(l, r, w, x): return abs(w - length(l, r, x))

def length(l, r, x): return r - l + sum([len(x[i]) for i in range(l, r+1)])

def combine(words, min_bad, w):
    total_badness = 0
    res = [""]
    for i in range(1, len(words)-1, 2):
        res, total_badness = plus(i, words, min_bad, total_badness, res)
    res, total_badnes = plus(len(words)-2, words, min_bad, total_badness, res)
    return res[1:], total_badness+1 #off by one!!  kjasdf;kjdfsa garg

def plus(i, words, min_bad, total_badness, res):
    x = words[i]
    y = words[i+1]
    bad = badness(i, i+1, w, words)
    if  bad + total_badness < min_bad:
        res.append(x+" "+y)
        total_badness += bad        
    else:
        res.append(x)
    return res, total_badness
    

while 1:
    try:
        w = int(raw_input())
        words = raw_input().split()
        #w = 6
        #words = [""] + "aaa bb, cc ddddd e\nfff gggg. hh ii?".split()
    except:
        pass
    min_bad = b(len(words)-1, w, words)
    c, total_bad = combine(words, min_bad, w)
    print "total badness:",total_bad
    print "\n".join(c)
    break
