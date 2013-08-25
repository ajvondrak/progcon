import sys

def bitfall(bits):
    toggle = False
    for i, bit in reversed(list(enumerate(bits))):
        if bit == 1:
            if toggle:
                bits[i] = 0
            toggle = not toggle
    return bits

def decimal(bits):
    return int(''.join(str(b) for b in bits), 2)

for width in sys.stdin.readlines():
    bits = [1] * int(width)
    fall = []
    while decimal(bits) != 1:
        fall.append(decimal(bits))
        bits = bitfall(bits)
    fall.append(1)
    print ' '.join(str(bits) for bits in fall)
