import java.util.*;

class gear_up {

	private static final Scanner in = new Scanner(System.in);

	private static class Ratio implements Comparable<Ratio> {

		private int numerator;
		private int denominator;

		Ratio(int numerator, int denominator) {
			this.numerator = numerator;
			this.denominator = denominator;
		}

		public int compareTo(Ratio r) {
			int compareTo = numerator * r.denominator - denominator * r.numerator;
			return compareTo != 0 ? compareTo : numerator - r.numerator;
		}

		public String toString() {
			return numerator + ":" + denominator;
		}
	}

	public static void main(String[] arguments) {

		List<Integer> front = new ArrayList<Integer>();
		for (Scanner line = new Scanner(in.nextLine()); line.hasNextInt(); front.add(line.nextInt())) ;

		List<Integer> rear = new ArrayList<Integer>();
		for (Scanner line = new Scanner(in.nextLine()); line.hasNextInt(); rear.add(line.nextInt())) ;

		List<Ratio> ratios = new ArrayList<Ratio>();
		for (int f : front) for (int r : rear) ratios.add(new Ratio(f, r));

		Collections.sort(ratios);
		for (Ratio r : ratios) System.out.println(r);
	}
}
