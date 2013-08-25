import sys

approval_tree = {}
petition_tree = {}

def leaves(tree):
    return [person for person in tree if not tree[person]]

copies_stored = {}

def send_petition(originator):
    node = originator
    path = []
    while petition_tree[node]:
        if petition_tree[node]:
            path.insert(0, petition_tree[node][0])
        node = petition_tree[node][0]
    ncopies = 1
    for person in path[1:]:
        ncopies += 1
        copies_stored.setdefault(person, 0)
        copies_stored[person] += ncopies
    copies_stored[originator] = ncopies

def dfs(person):
    print '%d copies stored at %s' % (copies_stored.get(person, 0), person)
    for underling in approval_tree[person]:
        dfs(underling)

def do_stuff():
    ultimate_authority = leaves(petition_tree)[0]
    petitioners = leaves(approval_tree) 
    for petitioner in petitioners:
        send_petition(petitioner)
    dfs(ultimate_authority)
    print

for line in sys.stdin.readlines():
    people = line.split()
    if not people:
        do_stuff()
        approval_tree = {}
        petition_tree = {}
        continue
    authority, underlings = people[0], people[1:]
    approval_tree[authority] = underlings
    petition_tree.setdefault(authority, [])
    for underling in underlings:
        petition_tree.setdefault(underling, []).append(authority)
