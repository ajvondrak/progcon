import sys
F=lambda f:5/9.*(f-32)
K=lambda k:k-273.15
C=lambda c:c
def k(i):
 t,d=i.split()
 return eval(d+'('+t+')'),d
for x in sorted(sys.stdin,key=k):print x[:-1]