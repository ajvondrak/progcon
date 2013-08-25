line = raw_input()
everyone = set()
descendants = {}
ancestors = {}
while line:
    father, mother, child = line.split()
    descendants.setdefault(father, set()).add(child)
    descendants.setdefault(mother, set()).add(child)
    ancestors.setdefault(child, set()).add(mother)
    ancestors[child].add(father)
    everyone.update(set([father, mother, child]))
    try: line = raw_input()
    except: break

for parent in everyone:
    oldsize = len(descendants.get(parent, []))
    for kid in list(descendants.get(parent, []))[:]:
        descendants[parent].update(descendants.get(kid, set()))
    newsize = len(descendants.get(parent, []))
    while newsize > oldsize:
        oldsize = len(descendants.get(parent, []))
        for kid in list(descendants.get(parent, []))[:]:
            descendants[parent].update(descendants.get(kid, set()))
        newsize = len(descendants.get(parent, []))

for kid in everyone:
    oldsize = len(ancestors.get(kid, []))
    for parent in list(ancestors.get(kid, []))[:]:
        ancestors[kid].update(ancestors.get(parent, set()))
    newsize = len(ancestors.get(kid, []))
    while newsize > oldsize:
        oldsize = len(ancestors.get(kid, []))
        for parent in list(ancestors.get(kid, []))[:]:
            ancestors[kid].update(ancestors.get(parent, set()))
        newsize = len(ancestors.get(kid, []))
        
#print descendants
#print ancestors
for x in raw_input().split():
    print x, "has", len(descendants.get(x, [])), "descendants and", \
          len(ancestors.get(x, [])), "ancestors"
