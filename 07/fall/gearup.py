#Sample in:
#22 32 42
#12 13 14 15 17 19 21 24 28
#Sample out:
#22:28
#22:24
#22:21
#32:28
#22:19
#22:17
#32:24
#22:15
#42:28
#32:21
#22:14
#32:19
#22:13
#42:24
#22:12
#32:17
#42:21
#32:15
#42:19
#32:14
#32:13
#42:17
#32:12
#42:15
#42:14
#42:13
#42:12
def val(ratio):
    return int(ratio.split(":")[0]) * 1.0 / int(ratio.split(":")[1])

def ratios(front, back):
    res = []
    for f in front:
        for b in back:
            res.append(repr(f)+":"+repr(b))
    res.sort(key=val)
    return res

def front_teeth(ratio):
    return int(ratio.split(":")[0]) 
    
while 1:
    try:
        front = map(int, raw_input().split())
        back = map(int, raw_input().split())
    except:
        break
    r = ratios(front, back)
    for i in range(1, len(r)):
        if val(r[i]) == val(r[i-1]):
            if front_teeth(r[i-1]) > front_teeth(r[i]):
                temp = r[i]
                r[i] = r[i-1]
                r[i-1] = temp
    for ratio in r: print ratio
