def add(b, k):
    return ''.join(str((x+y)%10) for (x,y) in zip(map(int, b), map(int, k)))

raw_input() #first line isn't used
while True:
    try: index, ballot, key = raw_input().split()
    except: break
    plain = add(ballot, key)
    print "plaintext ballot: %s  index: %s  vote for candidate: %s" %\
            (plain, index, plain[int(index)-1])
