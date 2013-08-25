def digits(n): return map(int, str(n))

def add(ballot, key):
    return ''.join(str((x+y)%10) for (x,y) in zip(digits(ballot), digits(key)))

candidates = int(raw_input())
while True:
    try:
        index, ballot, key = map(int, raw_input().split())
    except: break
    plaintext_ballot = add(ballot, key)
    candidate = plaintext_ballot[index-1]
    print "plaintext ballot: %s index: %d vote for candidate: %s" %\
            (plaintext_ballot, index, candidate)

