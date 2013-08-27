import java.util.*;

class cockeyed_boxes {

	static class Box {

		int small;
		int large;

		Box(int l, int w) {
			this.small = Math.min(l, w);
			this.large = Math.max(l, w);
		}

		int to(Box b) {
			return this == b ? 0 : this.small > b.large ? 1 : -1;
		}
	}

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		Map<String,Integer> names = new HashMap<String,Integer>();
		Box[] box = new Box[n];

		for (int i=0; i<n; i++) {
			String name = in.next();
			names.put(name, i);
			box[i] = new Box(in.nextInt(), in.nextInt());
		}
		long[][] distance = new long[n][n];

		for (int i=0; i<n; i++)
			for (int j=0; j<n; j++)
				distance[i][j] = box[i].to(box[j]);

		for (int k=0; k<n; k++)
			for (int i=0; i<n; i++)
				for (int j=0; j<n; j++)
					if (distance[i][k] >= 0 && distance[k][j] >= 0)
						distance[i][j] = Math.max(distance[i][j], distance[i][k]+distance[k][j]);

		while (in.hasNext()) {
			String start = in.next();
			int i = names.get(start);
			String end = in.next();
			int j = names.get(end);
			System.out.printf("most nested with outermost %s and innermost %s: %d%n", start, end, distance[i][j]+1);
		}
	}
}
