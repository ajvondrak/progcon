import sys

nodes, runs = sys.stdin.read().split('\n\n')

adjacency = {}
for line in nodes.split('\n'):
    parts = line.split()
    adjacency[int(parts[0])] = map(int, parts[1:])

for run in runs.split('\n')[:-1]:
    starting_amount_s, root_s = run.split()
    starting_amount = float(starting_amount_s)
    root = int(root_s)
    dry = set(adjacency.keys())
    accepts = {}
    q = [(root, starting_amount, None)]

    while q:
        node, inflow, source = q.pop()
        if node in dry:
            accepts[node] = (inflow, source)
            dry.remove(node)
            neighbors = [n for n in adjacency[node] if n in dry]
            for neighbor in reversed(neighbors):
                q.append((neighbor, inflow / (1.0*len(neighbors)), node))

    for node in sorted(adjacency.keys()):
        if node in accepts:
            inflow, source = accepts[node]
            print '%d accepts %.2f%s' % \
                (node, inflow, ('' if source is None else ' from %d' % source))
        else:
            print '%d accepts nothing' % node
    print
