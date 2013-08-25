import sys
import re

def trues(seq):
    return tuple(x for x in seq if x)

hierarchy_raw, declarations_raw, invocations_raw = sys.stdin.read().split('\n\n')

hierarchy = {}
for line in trues(hierarchy_raw.split('\n')):
    child, extends, parent = line.split()
    hierarchy.setdefault(child, []).append(parent)
    hierarchy[child].extend(hierarchy.get(parent, []))

declarations = {}
for line in trues(declarations_raw.split('\n')):
    meth = re.split('[ ,()]+', line)
    result_type = meth[0]
    method_name = meth[1]
    arg_types = trues(meth[2:])
    declarations.setdefault(method_name, []).append((result_type, arg_types, line))

invocations = []
for line in trues(invocations_raw.split('\n')):
    invoc = re.split('[ ,()]+', line)
    actual_result_type = invoc[0]
    method_name = invoc[1]
    actual_arg_types = trues(invoc[2:])
    invocations.append((method_name, actual_result_type, actual_arg_types, line))


def is_ancestor(parent, child):
    return parent == child or parent in hierarchy.get(child, [])

#print hierarchy

def matches((actual_method_name, actual_result_type, actual_arg_types, rep)):
    print "actual:", rep
    if actual_method_name not in declarations:
        return False
    for sig in declarations[actual_method_name]:
        #print '\tsig:', sig
        formal_result_type, formal_arg_types, formal_rep = sig
        same_len = (len(formal_arg_types) == len(actual_arg_types))
        same_ret = (formal_result_type == actual_result_type == "void" or \
                    is_ancestor(actual_result_type, formal_result_type))
        same_arg = all(is_ancestor(ft, at) \
                       for (at, ft) in zip(actual_arg_types, formal_arg_types))
        #print "\tsame len:", same_len
        #print "\tsame ret:", same_ret
        #print "\tsame arg:", same_arg
        #print
        if same_len and same_ret and same_arg:
            print "formal:", formal_rep

for invoc in invocations:
    matches(invoc)
    print
