import java.util.*;

class association {

	private static class Client {

		String name;
		List<String> protocols = new ArrayList<String>();
		int minSignal;
		Map<String,Integer> apSignals = new HashMap<String,Integer>(); // ap -> signal
	}

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);

		Map<String,List<String>> apProtocols = new HashMap<String,List<String>>(); // ap -> protocols

		while (true) {
			Scanner line = new Scanner(in.nextLine());
			if (! line.hasNext()) break;
			List<String> protocols = new ArrayList<String>();
			apProtocols.put(line.next(), protocols);

			while (true) {
				line = new Scanner(in.nextLine());
				if (! line.hasNext()) break;
				protocols.add(line.next());
			}
		}
				
		List<Client> clients = new ArrayList<Client>();

		while (true) {
			Scanner line = new Scanner(in.nextLine());
			if (! line.hasNext()) break;
			Client c = new Client();
			c.name = line.next();
			while (! in.hasNextInt()) c.protocols.add(in.next());
			c.minSignal = in.nextInt();
			in.nextLine();

			while (true) {
				line = new Scanner(in.nextLine());
				if (! line.hasNext()) break;
				c.apSignals.put(line.next(), line.nextInt());
			}
			clients.add(c);
		}

		for (Client client : clients) {
			String favoriteAP = null;
			String favoriteProtocol = null;
			int favoriteSignal = 0;

			for (String ap : client.apSignals.keySet()) {
				int signal = client.apSignals.get(ap);
				if (signal < client.minSignal) continue;
				if (favoriteAP != null && signal < favoriteSignal) continue;

				for (String protocol : client.protocols)

					if (apProtocols.get(ap).contains(protocol)) {
						favoriteAP = ap;
						favoriteProtocol = protocol;
						favoriteSignal = signal;
						break;
					}
			}
			System.out.printf("client %s ", client.name);

			if (favoriteAP != null)
				System.out.printf("associates with AP %s using protocol %s at signal strength %d%n", favoriteAP, favoriteProtocol, favoriteSignal);
			else
				System.out.printf("is not associated%n");
		}
	}
}
