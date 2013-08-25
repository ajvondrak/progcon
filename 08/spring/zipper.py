def search(source, left, right):
    if not (source or left or right): return "yes"
    if source and not (left or right): return "no"
    next_char = source[0]
    l = left and left[0]
    r = right and right[0]
    if next_char != l and next_char != r: return "no"
    if next_char == l and next_char == r:
        x = search(source[1:], left[1:], right)
        y = search(source[1:], left, right[1:])
        if x == "yes" or y == "yes": return "yes"
        else: return "no"
    if next_char == l:
        return search(source[1:], left[1:], right)
    if next_char == r:
        return search(source[1:], left, right[1:])

if __name__ == '__main__':
    while 1:
        try:
            line = raw_input()
            l, r, c = line.split()
        except: break
        output = "%s: %s ~ %s =? %s" % ("%s", l, r, c)
        if len(c) != len(l) + len(r):
            print output % "no"
            continue
        print output % search(c, l, r)
