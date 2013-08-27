data = [map(int, x.split()) for x in open("parking.in").readlines()][::2][1::]
for stores in data: print 2*(max(stores)-min(stores))