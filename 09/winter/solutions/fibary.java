import java.util.*;

class fibary {

	private static String fibonize(long x) {
		if (x == 0) return "0";
		if (x == 1) return "1";
		if (x == 2) return "10";

		LinkedList<Long> places = new LinkedList<Long>();
		places.addFirst(1L);
		places.addFirst(2L);

		while (true) {
			long next = places.get(0) + places.get(1);
			if (next > x) break;
			places.addFirst(next);
		}
		StringBuilder result = new StringBuilder();

		for (Long place : places) {

			if (place <= x) {
				result.append('1');
				x -= place;
			}
			else
				result.append('0');
		}
		return result.toString();
	}

	public static void main(String[] arguments) {
		Scanner in = new Scanner(System.in);

		while (in.hasNextInt())
			System.out.println(fibonize(in.nextInt()));
	}
}
