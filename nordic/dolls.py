for nums in [map(int, x.split()) for x in open("dolls.in").readlines()][::2][1::]:
    d = sorted(zip(nums[::2], nums[1::2]))
    print 1+sum([1 for (x,y) in zip(d,d[1:]) if x[0] > y[0] or x[1] > y[1]])