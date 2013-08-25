import sys
from string import lowercase as letters

v = dict(zip(letters, map(int, sys.stdin.readline().split())))

def multipliers():
    xs = map(int, sys.stdin.readline().split())
    return [tuple(xs[i:i+2]) for i in xrange(0, len(xs), 2)]

def L(x, y):
    global letter_multipliers_3, letter_multipliers_2
    if (x, y) in letter_multipliers_3: return 3
    if (x, y) in letter_multipliers_2: return 2
    return 1

def W(x, y):
    global word_multipliers_3, word_multipliers_2
    if (x, y) in word_multipliers_3: return 3
    if (x, y) in word_multipliers_2: return 2
    return 1

def prod(xs):
    return reduce(lambda x1, x2: x1 * x2, xs, 1)

while True:
    try:
        n = int(sys.stdin.readline())
        print '%dx%d board:' % (n, n)
    except:
        break

    letter_multipliers_2 = multipliers()
    letter_multipliers_3 = multipliers()
    word_multipliers_2 = multipliers()
    word_multipliers_3 = multipliers()

    while True:
        try:
            line = raw_input()
            w, x, y, direction = line.split()
        except:
            print
            break

        x = int(x)
        y = int(y)
        dx, dy = (1, 0) if direction == "across" else (0, -1)
        covered = [(w_i, x + dx * i, y + dy * i) for i, w_i in enumerate(w)]
        score = prod(W(x, y) for (_, x, y) in covered) * \
                sum(v[w_i] * L(x, y) for (w_i, x, y) in covered)

        print w, "at", "(%d,%d)" % (x, y), direction, "scores", score
