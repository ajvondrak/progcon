def cluster(f, lst): #my own bastardization of clusterBy...
    d = {}
    for x in lst: d.setdefault(f(x), []).append(x)
    for key in d: d[key] = sorted(d[key]) #...by keeping classes sorted
    return d
roles = {} #a hash of: UID => [FIDs that that UID has access to]
line = raw_input()
while line:
    line = map(int, line.split())
    fid = line[0]
    uids = line[1:]
    for uid in uids: roles.setdefault(uid, set()).add(fid)
    try: line = raw_input()
    except: break
classes = [] #lists of users with the access to exactly the same directories
alreadySeen = []
for user1 in roles:
    if user1 in alreadySeen: continue
    klass = [user1]
    for user2 in roles:
        if roles[user1] == roles[user2] and user1 != user2:
            klass.append(user2)
            alreadySeen.append(user2)
    classes.append(klass)
    alreadySeen.append(user1)
classes = [x for x in classes if len(x) > 1]#filter out single-user classes
if not classes:
    print "no prototypes found"
else:
    classes = cluster(len, classes)
    #classes now = hash of: len(class) => list classes with same length
    #each value in the hash is sorted so that classes with smaller min(UID)s
    #get printed first
    for length in reversed(sorted(classes.keys())):#num of members, descending
        for klass in classes[length]:
            print length, min(klass)