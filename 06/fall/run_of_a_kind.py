import re

for input in raw_input().split('\n'): #'input' needs to be the entire line
    input = ''.join([x for x in input.lower() if x in 'ht'])
    heads = max(re.findall('h*', input)) #find largest substring
    tails = max(re.findall('t*', input))
    input = input.replace(heads, heads.upper())
    input = input.replace(tails, tails.upper())
    print '\n', input
    print 'longest run of heads is', `len(heads)`
    print 'longest run of tails is', `len(tails)`, '\n'