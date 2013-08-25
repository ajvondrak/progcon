data = [map(int, x.split()) for x in open("shopaholic.in").readlines()][::2][1::]
for case in data: print sum(sorted(case)[:len(case)-len(case)%3:3])