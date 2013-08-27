import java.util.Scanner;

class bullet_hole {

	private static int vx, vy, vz;

	private static double x(double t) {
		return vx*t;
	}

	private static double y(double t) {
		return vy*t;
	}

	private static double z(double t) {
		return (vz - (4.9*t))*t;
	}

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);

		while (in.hasNextInt()) {

			vx = in.nextInt();
			vy = in.nextInt();
			vz = in.nextInt();

			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();

			int denom = a*vx + b*vy;

			if (denom == 0)
				System.out.printf("Travels parallel to plane%n");
			else {
				double t = (double)c / denom;

				if (t < 0) {
					System.out.printf("Travels away from plane%n");
				}
				else {
					System.out.printf("Impacts after %.2f seconds at position (%.2f, %.2f, %.2f)%n", t, x(t), y(t), z(t));
				}
			}
		}
	}
}
