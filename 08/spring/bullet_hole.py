def bullet_hole(a, b, c, vx, vy, vz):
    try:
        t = 1.0*c / (a*vx + b*vy)
        if t < 0: return "Travels away from plane"
        return "Impacts after %.2f seconds at position (%.2f, %.2f, %.2f)" % \
                (t, vx*t, vy*t, vz*t - 9.8*t**2 / 2.0)
    except ZeroDivisionError:
        return "Travels parallel to plane"

if __name__ == '__main__':
    while 1:
        try:
            line1 = raw_input()
            line2 = raw_input()
            raw_input()
        except: break
        vx, vy, vz = map(int, line1.split())
        a, b, c = map(int, line2.split())
        print bullet_hole(a, b, c, vx, vy, vz)
