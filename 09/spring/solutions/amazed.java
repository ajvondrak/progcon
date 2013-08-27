import java.util.*;

class amazed {

	private static class Vertex {

		int distance = Integer.MAX_VALUE;
		boolean visited = false;
		int r, c;

		Vertex(int r, int c) {
			this.r = r;
			this.c = c;
		}

		public String toString() {
			return distance + "@" + r + "," + c;
		}
	}

	private static Vertex min(Vertex[][] v) {
		int min_distance = Integer.MAX_VALUE;
		Vertex min = null;

		for (int r = 0; r < v.length; r++) {
			for (int c = 0; c < v[r].length; c++) {
				Vertex p = v[r][c];
				if (p != null && ! p.visited && p.distance < min_distance) {
					min_distance = p.distance;
					min = p;
				}
			}
		}
		return min;
	}

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);

		while (in.hasNextInt()) {
			Vertex[][] v = new Vertex[in.nextInt()][in.nextInt()];
			in.nextLine();

			for (int r = 0; r < v.length; r++) {
				char[] line = in.nextLine().toCharArray();

				for (int c = 0; c < v[r].length; c++) {
					if (line[c] == 'W') continue;
					Vertex p = v[r][c] = new Vertex(r, c);
					if (line[c] == 'S') p.distance = 0;
				}
			}
			while (true) {
				Vertex p = min(v);
				if (p == null) break;
				p.visited = true;
				int r = p.r;
				int c = p.c;
				try {
					Vertex q = v[r-1][c];
					if (q != null && ! q.visited && p.distance+1 < q.distance) q.distance = p.distance+1;
				} catch (Exception e) {}
				try {
					Vertex q = v[r][c+1];
					if (q != null && ! q.visited && p.distance+1 < q.distance) q.distance = p.distance+1;
				} catch (Exception e) {}
				try {
					Vertex q = v[r+1][c];
					if (q != null && ! q.visited && p.distance+1 < q.distance) q.distance = p.distance+1;
				} catch (Exception e) {}
				try {
					Vertex q = v[r][c-1];
					if (q != null && ! q.visited && p.distance+1 < q.distance) q.distance = p.distance+1;
				} catch (Exception e) {}
			}
			System.out.println();

			for (int r = 0; r < v.length; r++) {
				for (int c = 0; c < v[r].length; c++) {
					Vertex p = v[r][c];
					if (p == null)
						System.out.print("WWWWW");
					else if (p.distance == Integer.MAX_VALUE)
						System.out.print(" inf ");
					else
						System.out.printf(" %3d ", p.distance);
				}
				System.out.println();
			}
		}
	}
}
