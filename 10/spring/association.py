#ewwwwwwwwwwww

import sys

APs, clients = sys.stdin.read().split('\n\n\n')[:-1]

AP_protocols = {}
for AP in APs.split('\n\n'):
    parts = AP.split()
    AP_protocols[parts[0]] = parts[1:]

for client in clients.split('\n\n'):
    parts = client.split('\n')
    name = parts[0]
    protocols = []
    for i, arg in enumerate(parts[1:]):
        try:
            int(arg)
            break
        except:
            protocols.append(arg)
    min_signal = int(parts[i+1])
    APs_and_signals = (line.split() for line in parts[i+2:])
    APs_and_signals = [(AP, int(signal)) for AP, signal in APs_and_signals]

    viable_APs = [(AP, signal) for AP, signal in APs_and_signals if
                  (signal >= min_signal and
                   set(AP_protocols[AP]).intersection(set(protocols)))]

    if viable_APs:
        best_AP, strength = max(viable_APs, key = lambda (AP, signal): signal)
        protocol_used = [p for p in protocols if p in AP_protocols[best_AP]][0]
        print 'client %s associates with AP %s using protocol %s at signal strength %d' % (name, best_AP, protocol_used, strength)
    else:
        print 'client %s does not associate with any AP' % name
