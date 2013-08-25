import sys
def k(i):
 t,d=i.split()
 t=int(t)
 return {'F':5/9.*(t-32),'K':t-273.15,'C':t}[d],d
for x in sorted(sys.stdin,key=k):print x[:-1]