import sys

def l(line): return float(line.split()[0])
def r(line): return float(line.split()[1])
def g(line): return line.split()[2]
def h(line): return int(line.split()[3])

happinesses = [(g(line), h(line) * (r(line) - l(line)) / (107.9 - 87.9)) for
               line in sys.stdin.readlines()]

expected_happiness = sum(h for (g, h) in happinesses)
print "expected happiness: %.2f" % expected_happiness

max_happiness = max(h for (g, h) in happinesses)
most_happiness = [(h, g) for (g, h) in happinesses if h == max_happiness]
most_happiness.sort(key=lambda (h, g): g)
print "most happiness: %.2f from %s" % most_happiness[0]

min_happiness = min(h for (g, h) in happinesses)
least_happiness = [(h, g) for (g, h) in happinesses if h == min_happiness]
least_happiness.sort(key=lambda (h, g): g)
print "least happiness: %.2f from %s" % least_happiness[0]
