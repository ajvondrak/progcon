import java.util.*;

class knight_trip {

	private static int[] add(int[] left, int[] right) {
		return new int[]{left[0]+right[0], left[1]+right[1]};
	}

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);

		int[][] MOVES = {       {-1, 2}, { 1, 2},
		                    {-2, 1},         { 2, 1},
		                    {-2,-1},         { 2,-1},
		                        {-1,-2}, { 1,-2}        };
		int UNKNOWN = -1;

		while (in.hasNextInt()) {
			int          n        = in.nextInt();
			int[]        source   = new int[]{in.nextInt(), in.nextInt()};
			int[][]      breadth  = new int[n][n];
			Queue<int[]> frontier = new LinkedList<int[]>();

			System.out.printf("Minimum number of moves from (%1d,%1d) on a %1d by %1d board:%n%n", source[0], source[1], n, n);

			for (int x = 0; x < n; x++)
				for (int y = 0; y < n; y++)
					breadth[x][y] = UNKNOWN;
			breadth[--source[0]][--source[1]] = 0;

			frontier.offer(source);

			while (! frontier.isEmpty()) {
				int[] from = frontier.remove();

				for (int[] move : MOVES) {
					int[] to = add(from, move);

					try {
						if (breadth[to[0]][to[1]] == UNKNOWN) {
							breadth[to[0]][to[1]] = breadth[from[0]][from[1]] + 1;
							frontier.offer(to);
						}
					}
					catch (ArrayIndexOutOfBoundsException e) {}
				}
			}

			for (int y = n; --y >= 0;) {
				for (int x = 0; x < n; x++)
					System.out.printf("%4d", breadth[x][y]);
				System.out.println();
			}
			System.out.println();
		}
	}
}
