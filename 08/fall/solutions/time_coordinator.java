import java.util.*;

class time_coordinator {

	private static class Time implements Comparable<Time> {

		String format;
		int absolute;

		Time(String format) {
			this.format = format;
			Scanner in = new Scanner(format).useDelimiter("[:\\s\\+]+");
			int hour = in.nextInt();
			int minute = in.nextInt();
			int second = in.nextInt();
			int offset = in.nextInt();
			hour -= offset / 100;
			minute -= offset % 100;
			this.absolute = hour * 3600 + minute * 60 + second;
		}

		public int compareTo(Time to) {
			if (absolute != to.absolute) return absolute - to.absolute;
			return format.compareTo(to.format);
		}
	}

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);
		List<Time> times = new ArrayList<Time>();

		while (in.hasNextLine())
			times.add(new Time(in.nextLine()));

		Collections.sort(times);

		for (Time t : times)
			System.out.println(t.format);
	}
}
