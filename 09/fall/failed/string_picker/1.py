def pick(subword, word):
    if not subword:
        return 1
    if not word:
        return 0
    indices = (i for (i, ch) in enumerate(word) if ch == subword[0])
    # eek, stack space.  will this be a problem, or should I do it bottom-up?
    return sum(pick(subword[1:], word[i+1:]) for i in indices)

while True:
    try:
        subword, word = raw_input().split()
    except:
        break
    print '%d "%s" in "%s"' % (pick(subword, word), subword, word)
