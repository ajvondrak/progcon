from sys import stdin

def to_seconds(h, m, s): return s + m*60 + h*60*60

def parse_offset(offset):
    sign = -1 if offset[0] == '-' else 1
    return sign * to_seconds(int(offset[1:3]), int(offset[3:]), 0)

def utc(time):
    local_time, offset = time.split()
    return to_seconds(*map(int, local_time.split(":"))) - parse_offset(offset)

times = stdin.readlines()
times.sort(cmp=lambda t1,t2: cmp(utc(t1), utc(t2)) or cmp(t1, t2))
for time in times: print time.strip()
