import java.util.*;

class elevator {

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int start = in.nextInt();
		int direction = in.nextInt();
		System.out.printf("start        @ %d %s%n", start, direction > 0 ? "up" : "down");
		in.nextLine();
		Set<Integer> departures = new HashSet<Integer>();
		Map<Integer,Set<Integer>> arrivals = new HashMap<Integer,Set<Integer>>();

		for (Scanner token = new Scanner(in.nextLine()); token.hasNextInt();)
			departures.add(token.nextInt());

		while (in.hasNextLine()) {
			Scanner token = new Scanner(in.nextLine());
			int origin = token.nextInt();
			Set<Integer> destinations = new HashSet<Integer>();

			while (token.hasNextInt())
				destinations.add(token.nextInt());

			arrivals.put(origin, destinations);
		}
		for (int f = start; ! (departures.isEmpty() && arrivals.isEmpty()); f += direction) {

			if (departures.contains(f)) {
				System.out.printf("departure(s) @ %d %s%n", f, direction > 0 ? "up" : "down");
				departures.remove(f);
			}
			if (f == 1) direction = 1;
			if (f == n) direction = -1;

			if (arrivals.containsKey(f)) {
				Set<Integer> destinations = arrivals.get(f);

				for (int g = f+direction; 1 <= g && g <= n; g += direction)

					if (destinations.contains(g)) {
						System.out.printf("arrival(s)   @ %d %s going to %d%n", f, direction > 0 ? "up" : "down", g);
						departures.add(g);
						destinations.remove(g);
					}
				if (destinations.isEmpty()) arrivals.remove(f);
			}
		}
	}
}
