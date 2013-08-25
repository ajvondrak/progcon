memo = {}
def pick(subword, word):
    if not subword:
        return 1
    if len(subword) > len(word):
        return 0
    global memo
    if (subword, word) in memo:
        return memo[(subword, word)]
    indices = (i for (i, ch) in enumerate(word) if ch == subword[0])
    memo[(subword, word)] = sum(pick(subword[1:], word[i+1:]) for i in indices)
    return memo[(subword, word)]

while True:
    try:
        subword, word = raw_input().split()
    except:
        break
    print '%d "%s" in "%s"' % (pick(subword, word), subword, word)
