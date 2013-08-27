import java.util.*;

class traffic_shaper {

	private static final Scanner in = new Scanner(System.in);

	private static class Payload {

		private final int number;
		private final int arrival;
		private final int port;
		private int bytes;

		Payload(int number, int arrival, int port, int bytes) {
			this.number = number;
			this.arrival = arrival;
			this.port = port;
			this.bytes = bytes;
		}

		public String toString() {
			return "(port:" + port + ", number:" + number + ", arrival:" + arrival + ", bytes:" + bytes + ")";
		}
	}

	public static void main(String[] arguments) {

		int total = in.nextInt();
		Map<Integer,Integer> limits = new HashMap<Integer,Integer>();
		Map<Integer,Queue<Payload>> queues = new HashMap<Integer,Queue<Payload>>();

		while (in.hasNextInt()) {
			int port = in.nextInt();
			int limit = in.nextInt();
			total -= limit;

			limits.put(port, limit);
			queues.put(port, new LinkedList<Payload>());
		}
		limits.put(0, total);
		queues.put(0, new LinkedList<Payload>());

		in.next();

		int number = 0;
		while (in.hasNextInt()) {
			int arrival = in.nextInt();
			int port = in.nextInt();
			int bytes = in.nextInt();
			Queue<Payload> queue = queues.get(limits.containsKey(port) ? port : 0);
			queue.add(new Payload(++number, arrival, port, bytes));
		}

		int now = 0;
		boolean done;
		do {
			done = true;

			for (int port : queues.keySet()) {
				int limit = limits.get(port);
				Queue<Payload> queue = queues.get(port);

				for (Payload p; (p = queue.peek()) != null;) {
					done = false;
					if (p.arrival > now) break;

					if (p.bytes > limit) {
						p.bytes -= limit;
						break;
					}
					else {
						limit -= p.bytes;
						queue.remove();
						System.out.println("payload " + p.number + " port " + p.port + " done at " + (now+1));
					}
				}
			}
			now++;
		} while (! done);
	}
}
