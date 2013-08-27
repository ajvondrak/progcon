import java.util.Scanner;

class walk_the_line {

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);

		while (in.hasNextInt()) {
			int n = in.nextInt();
			int delta = in.nextInt();
			long[][] s = new long[n+1][n+1];

			for (int r = 0; r <= n; r++) {
				for (int c = r%2; c < r; c += 2)
					s[r][c] = s[r-1][Math.abs(c-1)] + s[r-1][c+1];
				s[r][r] = 1;
			}
			System.out.printf("%d %d-step walks end at %d%n", s[n][Math.abs(delta)], n, delta);
		}
	}
}
