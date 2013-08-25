import sys

def direction_name(d):
    if d == 1: return 'up'
    else: return 'down'

def cmp_floors(f1, f2, d):
    if d == 1:
        return f1 >= f2
    return f1 <= f2

class Elevator:
    def __init__(self, floor, maxfloor, direction, destinations, waiting):
        self.floor = floor
        self.maxfloor = maxfloor
        self.direction = direction
        self.destinations = destinations
        self.waiting = waiting

    def should_switch_direction(self):
        if self.floor == 1 or self.floor == self.maxfloor:
            return True
        if self.direction == 1:
            return (not self.destinations and all(a < self.floor for (a, d) in self.waiting)) and all(d < self.floor for d in self.destinations)
        return (not self.destinations and all(a > self.floor for (a, d) in self.waiting)) and all(d > self.floor for d in self.destinations)

    def step(self):
        #people might leave
        departures = set(d for d in self.destinations if d == self.floor)
        self.destinations -= departures
        if departures:
            print "departure(s) @", self.floor, direction_name(self.direction)
        #switch direction, if need be
        if self.should_switch_direction():
            self.direction = -self.direction
        #people might get on the elevator
        arrivals = set((arrival, dest) for (arrival, dest) in self.waiting \
                        if arrival == self.floor and \
                        cmp_floors(dest, self.floor, self.direction))
        self.waiting -= arrivals
        arrivals = set(y for (x,y) in arrivals)
        self.destinations.update(arrivals)
        if arrivals:
            for dest in arrivals:
                print "arrival(s)   @", self.floor, direction_name(self.direction), 'going to', dest
        #print '\t', vars(self)
        #continue sweep
        self.floor += self.direction

    def simulate(self):
        print "start        @", self.floor, direction_name(self.direction)
        while self.waiting or self.destinations:
            self.step()

maxfloor = int(raw_input())
floor, direction = map(int, raw_input().split())
destinations = set(map(int, raw_input().split()))
waiting = set()
for line in sys.stdin.readlines():
    data = map(int, line.split())
    arrival = data[0]
    dests = data[1:]
    waiting.update(set((arrival, dest) for dest in dests))
e = Elevator(floor, maxfloor, direction, destinations, waiting)
e.simulate()
