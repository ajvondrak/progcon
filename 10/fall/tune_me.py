import sys

def lrgh((l, r, g, h)): return float(l), float(r), g, int(h)

data = [lrgh(line.split()) for line in sys.stdin.readlines()]

h_contribs = [(h * (r - l) / (107.9 - 87.9), g) for (l, r, g, h) in data]

expected_happiness = sum(h for (h, g) in h_contribs)
print "expected happiness: %.2f" % expected_happiness

max_happiness = max(h for (h, g) in h_contribs)
max_genre = sorted(g for (h, g) in h_contribs if h == max_happiness)[0]
max_contrib = [h for (h, g) in h_contribs if g == max_genre][0]
print "most happiness: %.2f from %s" % (max_contrib, max_genre)

min_happiness = min(h for (h, g) in h_contribs)
min_genre = sorted(g for (h, g) in h_contribs if h == min_happiness)[0]
min_contrib = [h for (h, g) in h_contribs if g == min_genre][0]
print "least happiness: %.2f from %s" % (min_contrib, min_genre)
