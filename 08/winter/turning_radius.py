import math
line = raw_input()
while line:
    l, w, theta_in = map(float, line.split())
    r = (l / math.tan(math.radians(theta_in)))
    print "rear inside turn radius: %.2f" % r
    print "front outside wheel angle: %.2f" % math.degrees(math.atan(l/(r+w)))
    print 
    try: line = raw_input()
    except: break
