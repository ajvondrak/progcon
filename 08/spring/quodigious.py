def digits(n):
    return [int(digit) for digit in str(n)]

def prod(li):
    return reduce(lambda x, y: x*y, li)

def quodigious(n):
    return n % sum(digits(n)) == 0 and n % prod(digits(n)) == 0

if __name__ == '__main__':
    while 1:
        try:
            inp = raw_input().split()
            inp = map(int, inp)
        except: break
        for x in inp:
            for i in xrange(10**(x-1)+1, 10**x+1):
                if '0' in str(i) or '1' in str(i): continue
                if quodigious(i): print i
            print
