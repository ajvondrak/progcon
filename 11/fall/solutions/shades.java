import java.util.Scanner;

class shades {

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);

		int[] opaque = new int[10];
		int[] translucent = new int[10];

		while (in.hasNext()) {

			int w = in.nextInt();
			String shade = in.next();
			int setting = in.nextInt();

			if (shade.equals("opaque"))
				opaque[w] = setting;
			else if (shade.equals("translucent"))
				translucent[w] = setting;

			int light = 0;

			for (w=0; w<10; w++) {
				int translucent_percent = Math.max(translucent[w] - opaque[w], 0);
				int unshaded_percent = 100 - Math.max(translucent[w], opaque[w]);

				light += translucent_percent + 2 * unshaded_percent;
			}
			System.out.printf("%.0f%n", light/20d);
		}
	}
}
