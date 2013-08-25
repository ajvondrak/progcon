def digits(n): return map(int, n)

def add(ballot, key):
    return ''.join(str((x+y)%10) for (x,y) in zip(digits(ballot), digits(key)))

if __name__ == '__main__':
    candidates = int(raw_input())
    while True:
        try:
            index, ballot, key = raw_input().split()
        except: break
        plaintext_ballot = add(ballot, key)
        candidate = plaintext_ballot[int(index)-1]
        print "plaintext ballot: %s index: %s vote for candidate: %s" %\
                (plaintext_ballot, index, candidate)

