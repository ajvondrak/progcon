i=raw_input
while 1:
 try:d=i()+i()+i()+i()
 except:break
 print d.count('1')if int(d,2)in(16,68,84,257,273,325,341,365,455)else'invalid'