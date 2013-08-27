import java.util.Scanner;

class dancing_squares {

	static class Square {

		int n;
		char[][] s;

		Square(int n) {
			this.n = n;
			this.s = new char[n][n];
		}

		Square(int n, Scanner in) {
			this(n);

			for (int r=n-1; r>=0; r--) {
				String line = in.next();

				for (int c=0; c<n; c++)
					s[r][c] = line.charAt(c);
			}
		}

		public boolean equals(Object other) {

			for (int r=0; r<n; r++)
				for (int c=0; c<n; c++)
					if (s[r][c] != ((Square)other).s[r][c]) return false;

			return true;
		}

		Square rotate(int count) {

			if (count == 0)
				return this;
			else {
				Square result = new Square(n);

				for (int r=0; r<n; r++)
					for (int c=0; c<n; c++)
						result.s[r][c] = s[n-1-c][r];

				return result.rotate(count-1);
			}
		}

		Square hFlip() {

			Square result = new Square(n);

			for (int r=0; r<n; r++)
				for (int c=0; c<n; c++)
					result.s[r][c] = s[n-1-r][c];

			return result;
		}
	}

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Square first = new Square(n, in);

		for (int count=2; in.hasNext(); count++) {
			Square next = new Square(n, in);
			System.out.printf("Square %d is %s square 1.%n", count,
				(  first.equals(next.rotate(0))
				|| first.equals(next.rotate(0).hFlip())
				|| first.equals(next.rotate(1))
				|| first.equals(next.rotate(1).hFlip())
				|| first.equals(next.rotate(2))
				|| first.equals(next.rotate(2).hFlip())
				|| first.equals(next.rotate(3))
				|| first.equals(next.rotate(3).hFlip())
				)  ? "identical to" : "distinct from");
		}
	}
}
