from sys import stdin

def to_seconds(h, m, s):
    return s + m*60 + h*60*60

def parse_offset(offset):
    h_offset, m_offset = int(offset[1:3]), int(offset[3:])
    sign = -1 if offset[0] == '-' else 1
    return sign * to_seconds(h_offset, m_offset, 0)

def utc(time):
    local_time, offset = time.split()
    h, m, s = map(int, local_time.split(":"))
    local_seconds = to_seconds(h, m, s)
    offset = parse_offset(offset)
    return local_seconds - offset

def compare_utc_times(t1, t2):
    utc1, utc2 = utc(t1), utc(t2)
    if utc1 == utc2:
        return cmp(t1, t2)
    return cmp(utc1, utc2)

if __name__ == '__main__':
    times = stdin.readlines()
    times.sort(cmp=compare_utc_times)
    for time in times: print time
