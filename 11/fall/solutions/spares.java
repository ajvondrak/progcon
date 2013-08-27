import java.util.*;

class spares {

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);

		double r = Math.sqrt(3)/2;
		double[] x = {Double.NaN, 0, -.5, .5,  -1,   0,   1, -1.5, -.5,  .5, 1.5};
		double[] y = {Double.NaN, 0,   r,  r, 2*r, 2*r, 2*r,  3*r, 3*r, 3*r, 3*r};

		while (in.hasNextLine()) {

			Scanner line = new Scanner(in.nextLine());
			List<Integer> L = new ArrayList<Integer>();

			while (line.hasNextInt())
				L.add(line.nextInt());

			Double minI = null;
			for (int i : L) {

				double sumK = 0, meanK = 0;
				for (int k : L) {
					if (k == i) continue;

					Double minJ = null;
					for (int j : L) {
						if (j == k) continue;

						double penalty;
						if (y[j] >= y[k])
							penalty = Double.POSITIVE_INFINITY;
						else if (x[j] == x[k])
							penalty = 0;
						else {
							double deltaX = x[k] - x[j];
							double deltaY = y[k] - y[j];
							penalty = Math.sqrt(deltaX*deltaX + deltaY*deltaY);
						}
						if (minJ == null || penalty < minJ) minJ = penalty;
					}
					sumK += minJ;
				}
				if (L.size() > 1) meanK = sumK / (L.size()-1);
				if (minI == null || meanK < minI) minI = meanK;
			}
			System.out.printf("spare difficulty is %.3f%n", minI);
		}
	}
}
