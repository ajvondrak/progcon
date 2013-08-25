import sys, math, cmath

tassels = []
leaves  = []
ears    = []

while True:
    line = raw_input()
    if not line: break
    letter, height, theta, r = line.split()
    height = float(height)
    r = float(r)
    theta = math.radians(float(theta))
    {'t':tassels, 'l':leaves, 'e':ears}[letter].append((height, r, theta))

def tassel_error(y_cut):
    error = 0.0
    for (y, r, theta) in tassels:
        x_t = r * math.cos(theta)
        y_t = y + r * math.sin(theta)
        if y_cut >= y_t:
            error += r
            continue
        if y_cut <= y:
            continue
        x_cut = (y_cut - y) * x_t / (y_t - y)
        below = math.hypot(x_cut - 0, y_cut - y)
        error += below
    return error

def ear_leaf_error(y_cut):
    error = 0.0
    for (y, r, theta) in ears + leaves:
        x_t = r * math.cos(theta)
        y_t = y + r * math.sin(theta)
        if y_cut >= y_t:
            continue
        if y_cut <= y:
            error += r
            continue
        x_cut = (y_cut - y) * x_t / (y_t - y)
        above = math.hypot(x_t - x_cut, y_t - y_cut)
        error += above
    return error

for y_cut in sys.stdin.read().split():
    y_cut = float(y_cut)
    print "cut %.2f produces tassel error %.2f and ear/leaf error %.2f" % \
            (y_cut, tassel_error(y_cut), ear_leaf_error(y_cut))
