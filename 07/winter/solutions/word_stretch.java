import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class word_stretch {

	static class Point {

		final int x, y;
		double distance = Double.POSITIVE_INFINITY;
		Point previous = null;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		Point copy() {
			return new Point(this.x, this.y);
		}
	}

	public static void main(String[] arguments) throws java.io.IOException {

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		List<Point>[] b = (List<Point>[])new List<?>[128];
		for (int c = 0; c < 128; c++)
			b[c] = new ArrayList<Point>();

		for (int y = n; --y >= 0;)
			for (int x = 0; x < n; x++)
				b[in.next().charAt(0)].add(new Point(x, y));

		while (in.hasNext()) {
			String word = in.next();
			List<Point>[] path = (List<Point>[])new ArrayList<?>[word.length()];

			for (int i = 0; i < word.length(); i++) {
				path[i] = new ArrayList<Point>();

				for (Point p : b[word.charAt(i)])
					path[i].add(p.copy());
			}

			for (Point p : path[0])
				p.distance = 0;

			for (int i = 1; i < word.length(); i++)
				for (Point q : path[i])
					for (Point p : path[i-1]) {
						double distance = p.distance + Math.sqrt((q.x-p.x)*(q.x-p.x) + (q.y-p.y)*(q.y-p.y));
						if (distance < q.distance) {
							q.distance = distance;
							q.previous = p;
						}
					}

			double distance = Double.POSITIVE_INFINITY;
			Point last = null;
			for (Point q : path[word.length()-1])
				if (q.distance < distance) {
					distance = q.distance;
					last = q;
				}

			System.out.printf("least-stretched occurrence of \"%s\": %.2f%n", word, distance);

			Stack<Point> stretch = new Stack<Point>();

			while (last != null) {
				stretch.push(last);
				last = last.previous;
			}

			for (int i = 0; i < word.length(); i++) {
				Point p = stretch.pop();
				System.out.printf("%d %d%n", p.x, p.y);
			}
			System.out.println();
		}
	}
}
