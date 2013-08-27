import java.util.*;

class fade_to_black {

	private static class Color implements Comparable<Color> {
		long r, g, b;
		String name;

		Color(String rgb) {
			r = Integer.parseInt(rgb.substring(0,2), 16);
			g = Integer.parseInt(rgb.substring(2,4), 16);
			b = Integer.parseInt(rgb.substring(4,6), 16);
			name = rgb;
		}

		private long distance() {
			return r*r + g*g + b*b;
		}

		public int compareTo(Color r) {
			long l_distance = distance();
			long r_distance = r.distance();
			return
				l_distance > r_distance ? -1 :
				l_distance < r_distance ? +1 : name.compareTo(r.name);
		}
	}

	public static void main(String[] arguments) {
		Scanner in = new Scanner(System.in);
		List<Color> colors = new ArrayList<Color>();

		while (in.hasNextLine())
			colors.add(new Color(in.nextLine()));

		Collections.sort(colors);

		for (Color c : colors)
			System.out.println(c.name);
	}
}
