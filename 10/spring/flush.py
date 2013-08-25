import sys
from collections import deque

nodes, runs = sys.stdin.read().split('\n\n')

adjacency = {}
for line in nodes.split('\n'):
    parts = line.split()
    adjacency[int(parts[0])] = map(int, parts[1:])

for run in runs.split('\n')[:-1]:
    starting_amount_s, root_s = run.split()
    starting_amount = float(starting_amount_s)
    root = int(root_s)
    accepts = {}
    q = deque([(root, starting_amount, None)])

    while q:
        node, inflow, source = q.popleft()
        if node not in accepts: # dry
            accepts[node] = (inflow, source)
            q_nodes = [n for n, _, _ in q]
            outgoing = [n for n in adjacency[node] if n not in accepts] # dry
            outgoing = [n for n in outgoing if n not in q_nodes]
            for next in outgoing:
                q.append((next, inflow / (1.0*len(outgoing)), node))

    for node in sorted(adjacency.keys()):
        if node in accepts:
            inflow, source = accepts[node]
            print '%d accepts %.2f%s' % \
                (node, inflow, ('' if source is None else ' from %d' % source))
        else:
            print '%d accepts nothing' % node
    print
