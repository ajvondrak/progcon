import java.util.*;

class tune_me {

	private static final double DIAL = 107.9 - 87.9;

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);

		double h = 0.0;
		SortedMap<String,Double> genres = new TreeMap<String,Double>();

		while (in.hasNext()) {
			double l_i = in.nextDouble();
			double r_i = in.nextDouble();
			String g_i = in.next();
			double h_i = in.nextDouble();

			double contribution = h_i * (r_i-l_i)/DIAL;
			h += contribution;

			Double h_g = genres.get(g_i);
			genres.put(g_i, (h_g != null ? h_g : 0.0) + contribution);
		}
		System.out.printf("expected happiness: %.2f%n", h);

		String max_g = null;
		double max_h_g = Double.NEGATIVE_INFINITY;
		String min_g = null;
		double min_h_g = Double.POSITIVE_INFINITY;

		for (Map.Entry<String,Double> e : genres.entrySet()) {
			String g = e.getKey();
			double h_g = e.getValue();
//			System.out.printf("genre happiness: %.2f from %s%n", h_g, g);

			if (h_g > max_h_g) {
				max_g = g;
				max_h_g = h_g;
			}
			if (h_g < min_h_g) {
				min_g = g;
				min_h_g = h_g;
			}
		}
		System.out.printf("most happiness: %.2f from %s%n", max_h_g, max_g);
		System.out.printf("least happiness: %.2f from %s%n", min_h_g, min_g);
	}
}
