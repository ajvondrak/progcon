while True:
    try:
        w_in, h_in, w_dev, h_dev = map(int, raw_input().split())
    except:
        break
    in_aspect_ratio = w_in / (1.0 * h_in)
    dev_aspect_ratio = w_dev / (1.0 * h_dev)
    if in_aspect_ratio >= dev_aspect_ratio:
        factor = w_dev / (1.0 * w_in)
    else:
        factor = h_dev / (1.0 * h_in)
    print "w x h = %d x %d pixels" % (w_in * factor, h_in * factor)
