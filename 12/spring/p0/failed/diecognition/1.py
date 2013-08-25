i=raw_input
while 1:
 try:t,m,b,_=i(),i(),i(),i()
 except:break
 print'invalid'if t!=''.join(reversed(b))or m not in('010','000')else(t+m+b).count('1')