import sys
from collections import deque

empty = ' '
wall  = 'W'
start = 'S'

def gen_moves(graph, (x,y), searched):
    return (move for move in ((x+1, y), (x-1, y), (x, y+1), (x, y-1))
            if (move in graph) and (graph[move] == empty) and (move not in searched))

def breadth_first_search(graph, starting_node):
    depths = {}
    searched = set()
    unsearched = deque([(starting_node, 0)])
    while unsearched:
        node, depth = unsearched.popleft()
        searched.add(node)
        for m in gen_moves(graph, node, searched):
            unsearched.append((m, depth + 1))
            depths[m] = depth + 1
    return depths

def format(n):
    return '%5s' % (str(n) + ' ')

while True:
    try:
        nr, nc = map(int, raw_input().split())
        print
    except:
        break
    graph = {}
    for r in range(nr):
        col = raw_input()
        for c in range(len(col)):
            graph[(r, c)] = col[c]
            if graph[(r, c)] == start:
                starting_node = (r, c)
    depths = breadth_first_search(graph, starting_node)
    for r in range(nr):
        for c in range(nc):
            if graph[(r, c)] == wall:
                sys.stdout.write(wall*5)
            elif graph[(r, c)] == empty:
                sys.stdout.write(format(depths.get((r,c), 'inf')))
            elif graph[(r, c)] == start:
                sys.stdout.write(format(0))
        sys.stdout.write('\n')
