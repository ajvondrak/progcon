def digits(n):
    return [int(digit) for digit in str(n)]

def prod(li):
    return reduce(lambda x, y: x*y, li)

def quodigious(n):
    return n % sum(digits(n)) == 0 and n % prod(digits(n)) == 0

if __name__ == '__main__':
    while 1:
        try: inp = int(raw_input())
        except: break
        for i in xrange(10**(inp-1)+1, 10**inp+1):
            if '0' in str(i) or '1' in str(i): continue
            if quodigious(i): print i
        print
