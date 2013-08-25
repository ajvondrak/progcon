from sys import stdin

payout = {2:2, 3:1, 4:1, 5:-1, 6:-1, 7:-1, 8:-1, 9:1, 10:1, 11:1, 12:3}

def best_streak(payouts):
    totals = {}
    for start in xrange(len(payouts)):
        total = 0
        for n, payout in enumerate(payouts[start:]):
            total += payout
            totals[(start, start+n)] = total
    best = max(totals.values())
    return (range for range in totals if totals[range] == best), best

def format_ranges(ranges):
    return ' '.join('%d-%d' % (start+1, end+1) for start, end in ranges)

cases = stdin.read().split('\n\n')[:-1]
for case in cases:
    string_of_rolls = map(lambda roll: sum(map(int, roll.split())),
                          case.split('\n'))
    payouts = [payout[roll] for roll in string_of_rolls]
    ranges, total = best_streak(payouts)
    print "best winning streak is $%d from rolls %s" %\
            (total, format_ranges(sorted(ranges)))
