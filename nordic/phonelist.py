def phonelist(phones):
    for x in phones:
        for y in phones:
            if x != y and x.startswith(y): return "NO"
    return "YES"
data = iter(open("phonelist.in").readlines())
for i in range(int(data.next())):
    print phonelist([data.next().strip() for j in range(int(data.next()))])