import sys, fractions

all_possibles = [[one, two, tre] for one in range(1,7)
                                 for two in range(1,7)
                                 for tre in range(1,7)]

def of_a_kind(n, faces):
    return n == 3 - len(set(faces)) + 1

def p(n, known):
    possibles = [triple for triple in all_possibles
                        if triple[:len(known)] == known]
    numer = len([triple for triple in possibles if of_a_kind(n, triple)])
    denom = len(possibles)
    gcd = fractions.gcd(numer, denom)
    return '%d/%d' % (numer / gcd, denom / gcd)

for rolls in sys.stdin.readlines():
    rolls = map(int, rolls.split())
    for nknown in range(0, 4):
        print ' '.join(p(n, rolls[:nknown]) for n in range(1, 4))
    print
