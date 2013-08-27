import java.util.Scanner;

class turning_radius {

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);

		while (in.hasNextDouble()) {

			double l = in.nextDouble();
			double w = in.nextDouble();
			double theta_in = in.nextDouble() * Math.PI / 180;
			double r = l / Math.tan(theta_in);
			double theta_out = Math.atan(l / (r+w)) * 180 / Math.PI;

			System.out.printf(" rear inside  turn radius: %.2f%n", r);
			System.out.printf("front outside wheel angle: %.2f%n", theta_out);
			System.out.println();
		}
	}
}
