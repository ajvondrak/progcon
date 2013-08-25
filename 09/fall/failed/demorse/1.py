import sys

morse = {'*-':'a',
         '-***':'b',
         '-*-*':'c',
         '-**':'d',
         '*':'e',
         '**-*':'f',
         '--*':'g',
         '****':'h',
         '**':'i',
         '*---':'j',
         '-*-':'k',
         '*-**':'l',
         '--':'m',
         '-*':'n',
         '---':'o',
         '*--*':'p',
         '--*-':'q',
         '*-*':'r',
         '***':'s',
         '-':'t',
         '**-':'u',
         '***-':'v',
         '*--':'w',
         '-**-':'x',
         '-*--':'y',
         '--**':'z'}

def demorse(word):
    letters = word.split('0'*3)
    for letter in letters:
        tones = letter.split('0')
        yield morse[''.join({'1':'*', '111':'-'}[tone] for tone in tones)]

while True:
    try:
        line = raw_input()
    except:
        break
    words = line.split('0'*7)
    print ' '.join(''.join(demorse(word)) for word in words)
