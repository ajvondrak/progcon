import sys

n = int(raw_input())

base_dimensions = {}

for _ in xrange(n):
    b, l, w = raw_input().split()
    base_dimensions[b] = (int(l), int(w))

def longer_base_dimension(box):
    return max(base_dimensions[box])

def smaller_base_dimension(box):
    return min(base_dimensions[box])

def can_be_nested(outer_box, inner_box):
    return longer_base_dimension(inner_box) < smaller_base_dimension(outer_box)

boxes = base_dimensions.keys()

memo = {}
def max_cockeyed_nesting(outermost, innermost):
    global memo
    if (outermost, innermost) in memo:
        return memo[(outermost, innermost)]
    if outermost == innermost:
        score = 1
    elif not can_be_nested(outermost, innermost):
        score = 0
    else:
        score = 1 + max(max_cockeyed_nesting(box, innermost) \
                        for box in boxes if can_be_nested(outermost, box))
    memo[(outermost, innermost)] = score
    return score

for pair_of_box_names in sys.stdin.readlines():
    outermost, innermost = pair_of_box_names.split()
    print "most nested with outermost %s and innermost %s: %d" % \
            (outermost, innermost, max_cockeyed_nesting(outermost, innermost))
