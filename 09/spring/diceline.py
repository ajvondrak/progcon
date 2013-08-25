import sys

def autoassign(self, locals):
    for (var, val) in locals.iteritems():
        if var != 'self':
            setattr(self, var, val)

def opposite_face(face):
    return {'n':'s', 's':'n', 'e':'w', 'w':'e', 'u':'d', 'd':'u'}[face]

def opposite_val(val):
    if val == 0: return 0
    return 7 - val

class die:
    def __init__(self, n=0, e=0, s=0, w=0, u=0, d=0):
        autoassign(self, locals())
        self.verdict = 'not sure'

    def __str__(self):
        return '\n'.join(['N:%s' % self.n,
                          'E:%s' % self.e,
                          'S:%s' % self.s,
                          'W:%s' % self.w,
                          'U:%s' % self.u,
                          'D:%s' % self.d])

    def knowledge(self):
        for face in 'neswud':
            self.set_face(opposite_face(face), opposite_val(getattr(self, face)))
        if self.verdict != 'inconsistent':
            faces = set(getattr(self, face) for face in 'neswud')
            knowns = [getattr(self, face) for face in 'newsud' if getattr(self, face) != 0]
            if len(faces) == 6 and (0 not in faces): #will ACID reveal that I need to test corners?
                self.verdict = 'known'
            elif len(knowns) != len(set(knowns)):
                self.verdict = 'inconsistent'
            else:
                self.verdict = 'unknown'
        return self.verdict

    def set_face(self, face, val):
        if getattr(self, face) == 0:
            setattr(self, face, val)
        elif getattr(self, face) == val or val == 0:
            return
        else:
            self.verdict = 'inconsistent'

new_inst = True
for line in sys.stdin:
    line = line.strip()
    if new_inst:
        ndice = int(line)
        dice = [die() for _ in range(ndice)]
        new_inst = False
        continue
    if not line:
        for i, die_i in enumerate(dice):
            print 'die', i, 'is', die_i.knowledge()
            #print str(die_i)
        print
        new_inst = True
        continue
    face, vals = line.split(':')
    face = face.lower()
    for die_i, val in zip(dice, vals.split(',')):
        die_i.set_face(face, int(val))
