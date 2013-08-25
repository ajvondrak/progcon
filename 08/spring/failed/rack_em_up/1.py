def score(frames):
    total = 0
    output = ""
    format = "%5d"
    s_i_minus_2 = 0
    s_i_minus_1 = 0
    for x, frame in enumerate(frames):
        r = len(frame)
        p = sum(frame)
        i = x + 1
        if p == 10 and r == 1 and i >= 3:
            s = p + s_i_minus_1 + s_i_minus_2
        elif p == 10 and ( (r==2 and i >= 2) or (r==1 and i==2) ):
            s = p + s_i_minus_1
        else:
            s = p
        output += format % s
        total += s
        s_i_minus_2 = s_i_minus_1
        s_i_minus_1 = s
    output += "%-5s" % " = "
    output += format % total
    return output

if __name__ == '__main__':
    while 1:
        try:
            line = raw_input()
            pins = map(int, line.split())
        except: break
        frames = []
        prev_pin = None
        for p in pins:
            if p == 10:
                frames.append( (p,) )
            else:
                if prev_pin:
                    frames.append( (prev_pin, p) )
                    prev_pin = None
                else:
                    prev_pin = p
        if len(frames) != 10: print "Error processing score sheet"
        print score(frames)
