##I think this may be some of the uglier code I've written.  But it seems to
##work on the tests provided.  -- Alex Vondrak

VALUE = {"2":2, "3":3, "4":4, "5":5, "6":6, "7":7, "8":8, "9":9, "T":10, "J":11, "Q":12, "K":13, "A":14}

def uniq(li): return {}.fromkeys(li, 0).keys()

def rank(hand):
    #return rank string, score, and highest cards list for particular hand
    suits = uniq([card[1] for card in hand])
    vals  = [VALUE[card[0]] for card in hand]; vals.sort()
    pairs = [v for v in vals if vals.count(v)==2]
    triples = [v for v in vals if vals.count(v)==3]
    quad = [v for v in vals if vals.count(v)==4]
    consecutive = (range(vals[0], vals[-1] + 1) == vals)
    lones = uniq(vals)
        
    if len(suits)==1 and consecutive:
        return "straight flush", 8, [max(vals)]
    elif quad:
        return "four of a kind", 7, [quad[0]]
    elif triples and pairs:
        return "full house", 6, [triples[0]]
    elif len(suits)==1:
        return "flush", 5, vals[::-1]
    elif consecutive:
        return "straight", 4, [max(vals)]
    elif triples:
        lones.remove(triples[0])
        lones.sort()
        return "three of a kind", 3, [triples[0]] + lones[::-1] 
    elif len(pairs) == 4:
        lones.remove(max(pairs))
        lones.remove(min(pairs))
        lones.sort()
        return "two pairs", 2, [max(pairs), min(pairs)] + lones[::-1]
    elif pairs:
        lones = uniq(vals)
        lones.remove(pairs[0])
        lones.sort()
        return "one pair", 1, [pairs[0]] + lones[::-1]
    else:
        return "high card", 0, vals[::-1]
    

def compare(h1, h2):
    r1, score1, high1 = rank(h1)
    r2, score2, high2 = rank(h2)
    if score1 > score2:
        return r1 + " beats " + r2
    elif score2 > score1:
        return r1 + " loses to " + r2
    else:
        for i in range( min( [len(high1), len(high2)] ) ):
            if high1[i] > high2[i]:
                return r1 + " beats " + r2
            elif high2[i] > high1[i]:
                return r1 + " loses to " + r2
        return r1 + " ties " + r2


#Tested for input x equal to ...:
#x = "2h 3d 5s 9c kd   2c 3h 4s 8c ah"
#x = "2h 4s 4c 2d 4h    2s 8s as qs 3s"
#x = "2h 3d 5s 9c kd    2c 3h 4s 8c kh"
#x = "2h 3d 5s 9c kd   2d 3h 5c 9s kh"
#x = "4h 9s 4c th js   8d 7d 4s 4d td"
#x = "7h 8d 9h th jc   8h 9d tc js qs"
#x = "6d 8h 8s 2c 2d   5s 8d 8c 2h 2s"
#All pass.

2h 3d 5s 9c kd   2c 3h 4s 8c ah
2h 4s 4c 2d 4h    2s 8s as qs 3s
2h 3d 5s 9c kd    2c 3h 4s 8c kh
2h 3d 5s 9c kd   2d 3h 5c 9s kh
4h 9s 4c th js   8d 7d 4s 4d td
7h 8d 9h th jc   8h 9d tc js qs
6d 8h 8s 2c 2d   5s 8d 8c 2h 2s

while 1:
    try:
        hands = raw_input('-->').upper().split()
        hand1 = hands[0:5]
        hand2 = hands[5:]
        print compare(hand1, hand2)
    except: pass
