import sys

n = int(raw_input())

base_dimensions = {}

for _ in xrange(n):
    b, l, w = raw_input().split()
    base_dimensions[b] = (int(l), int(w))

order = [b for b, dims in sorted(base_dimensions.items(),
                                 key = lambda (b, dims): dims,
                                 reverse=True)]

def longer_base_dimension(box):
    return max(base_dimensions[box])

def smaller_base_dimension(box):
    return min(base_dimensions[box])

def can_be_nested(outer_box, inner_box):
    return longer_base_dimension(inner_box) < smaller_base_dimension(outer_box)

def max_cockeyed_nesting(outermost, innermost):
    o_index = order.index(outermost)
    i_index = order.index(innermost)
    if i_index < o_index:
        return 0
    if i_index == o_index:
        return 1
    score = int(can_be_nested(outermost, innermost))
    current_box = outermost
    for box in order[o_index+1:i_index+1]:
        if can_be_nested(current_box, box):
            score += 1
            current_box = box
    return score

for pair_of_boxes in sys.stdin.readlines():
    outermost, innermost = pair_of_boxes.split()
    print "most nested with outermost %s and innermost %s: %d" % \
            (outermost, innermost, max_cockeyed_nesting(outermost, innermost))
