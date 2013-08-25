# Dihedral group 4?

def r1(square):
    new_square = {}
    for r, row in square:
        new_square[r] = {}
        for c, item in row:
            new_square[r][c] = square[c][r]
    return new_square

def r2(square):
    return r1(r1(square))

def r3(square):
    return r1(r2(square))

import sys

n = int(sys.stdin.readline())

squares = [

while True:
    line = sys.stdin.readline()
