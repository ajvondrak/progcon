import java.util.Scanner;

class oblique_cuboid {

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);

		while (in.hasNextInt()) {

			int h = in.nextInt();
			int w = in.nextInt();
			int d = in.nextInt();

			char[][] grid = new char[h+d+1][w+d+1];

			for (int y = h+d; y >= 0; y--)
				for (int x = 0; x <= w+d; x++)
					grid[y][x] = ' ';

			for (int x = 0; x <= w; x++)
				grid[0][x] = grid[h][x] = grid[d][x+d] = grid[h+d][x+d] = '*';

			for (int y = 0; y <= h; y++)
				grid[y][0] = grid[y][w] = grid[y+d][d] = grid[y+d][w+d] = '*';

			for (int i = 0; i <= d; i++)
				grid[i][i] = grid[i][i+w] = grid[i+h][i] = grid[i+h][w+i] = '*';

			for (int y = h+d; y >= 0; y--) {
				for (int x = 0; x <= w+d; x++)
					System.out.print(grid[y][x]);
				System.out.println();
			}
			System.out.println();
		}
	}
}
