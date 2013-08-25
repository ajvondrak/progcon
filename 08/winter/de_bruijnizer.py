def substrings(li, n, res = []):
    if not res: res = [""] * len(li)
    if n > 0:
        blah = []
        for x in res:
            for y in li:
                blah.append(x+y)
        return substrings(li, n-1, list(set(blah)))
    return res

#def perms(remain, curr=[], res=[]):
#    res.append(curr)
#    for x in remain:
#        res = perms([i for i in remain if i != x], curr+[x], res)
#    return res

def de_bruijnize(li):
    li.sort()
    s = li.pop(0)
    li.sort(reverse=True)
    for x in li:
        #print x
        if x not in s:
            #print "before:",s
            s = merge(s,x)
            #print "after: ",s
    return s

#def merge(li):
#    s = ""
#    for x in li:
#        i = 1
#        while i < len(x) and s.endswith(x[:i]):
#            i += 1
#        s += x[i-1:]
#    return s

def merge(s1, s2):
    i = len(s2)
    while not s1.endswith(s2[:i]) and i > 0:
        i -= 1
    return s1 + s2[i:]

line = raw_input()
while line:
    k, n = map(int, line.split())
    alphabet = map(str, range(k))
    possibles = substrings(alphabet, n)
    print de_bruijnize(possibles)
    try: line = raw_input()
    except: break
