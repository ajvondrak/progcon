import java.util.*;

class perfect_slice {

	private static class Pepperoni {

		private double x, y, radius, distance, radialSpread, centerTheta;

		private Pepperoni(double x, double y, double radius) throws IllegalArgumentException {
			this.x = x;
			this.y = y;
			this.radius = radius;
			distance = Math.hypot(x, y);
			if (distance <= radius) throw new IllegalArgumentException("center covered");
			radialSpread = Math.asin(radius/distance);
			centerTheta = Math.atan2(y, x);
		}

		private double slice(Pepperoni t) throws IllegalArgumentException {
			double opposite = Math.hypot(x-t.x, y-t.y);
			double spread = Math.acos((distance*distance + t.distance*t.distance - opposite*opposite) / (2*distance*t.distance));
			double separation = spread - radialSpread - t.radialSpread;
			if (separation <= 0) throw new IllegalArgumentException("no slice between them");
			Pepperoni start = null;
			if (Math.abs(centerTheta - t.centerTheta) <= Math.PI)
				start = centerTheta < t.centerTheta ? this : t;
			else
				start = centerTheta > t.centerTheta ? this : t;
			double slice = start.centerTheta + start.radialSpread + separation/2;
			return Math.toDegrees(slice > Math.PI ? slice - Math.PI : slice);
		}

		public String toString() {
			return "x=" + x + " y=" + y + " radius=" + radius + " distance=" + distance + " radialSpread=" + radialSpread + " centerTheta=" + centerTheta;
		}
	}

	public static void main(String[] arguments) {
		Scanner in = new Scanner(System.in);

		while (in.hasNextDouble())
			try {
				double x1=in.nextDouble(), y1=in.nextDouble(), radius1=in.nextDouble();
				double x2=in.nextDouble(), y2=in.nextDouble(), radius2=in.nextDouble();
				Pepperoni p1 = new Pepperoni(x1, y1, radius1);
				Pepperoni p2 = new Pepperoni(x2, y2, radius1);
				System.out.printf("slice at %.2f degrees%n", p1.slice(p2));
			} catch (IllegalArgumentException e) {System.out.println(e.getMessage());}
	}
}
