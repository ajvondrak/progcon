import java.util.Scanner;

class wiper_swipe {

	private static double xl, yb, xr, yt;
	private static double corner;

	private static double right(double x, double y) {
		double length = Math.sqrt(x*x + y*y);

		if (length > corner) // bumps right (xr)
			return Math.acos(xr / length);
		else // bumps bottom (yb)
			return Math.asin(yb / length);
	}

	private static double left(double x, double y) {
		double length = Math.sqrt(x*x + y*y);

		if (length > yt) // bumps top (yt)
			return Math.asin(yt / length);
		else // sweeps left as far as right
			return Math.PI - right(x, y);
	}

	private static double degrees(double theta) {
		return theta * 180 / Math.PI;
	}

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);

		while (in.hasNextDouble()) {
			xl = in.nextDouble();
			yb = in.nextDouble();
			xr = in.nextDouble();
			yt = in.nextDouble();

			corner = Math.sqrt(xr*xr + yb*yb);

			double x1 = in.nextDouble();
			double y1 = in.nextDouble();
			double x2 = in.nextDouble();
			double y2 = in.nextDouble();

			double delta = Math.atan2(y1, x1) - Math.atan2(y2, x2);
			double right = Math.max(right(x1, y1), right(x2, y2) + delta);
			double left = Math.min(left(x1, y1), left(x2, y2) + delta);
//			System.out.printf("inner diameter %.2f sweeps from %.2f to %.2f%n", 2*Math.sqrt(x1*x1 + y1*y1), -left, -right);
//			System.out.printf("outer diameter %.2f sweeps from %.2f to %.2f%n", 2*Math.sqrt(x2*x2 + y2*y2), delta-left, delta-right);
			System.out.printf("wiper arm swipes from %.2f to %.2f degrees%n", degrees(right), degrees(left));
		}
	}
}
