import sys

def next(string):
    try:
        lastc = string[-1]
    except IndexError:
        return 'a'
    if lastc == 'a':
        return string[:-1] + 'b'
    elif lastc == 'b':
        return string[:-1] + 'c'
    elif lastc == 'c':
        return next(string[:-1]) + 'a'

for line in sys.stdin:
    line = line.strip()
    absent = 'a'
    while absent in line:
        absent = next(absent)
    print absent, 'is absent from', line
