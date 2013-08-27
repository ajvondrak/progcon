import java.util.Scanner;

class bitfall {

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);

		while (in.hasNextInt()) {
			int n = in.nextInt(); // 1 <= n < 63
			long x = (1L<<n) - 1;
			System.out.print(x);

			while (x > 1) {
				long mask = 1;
				int parity = 0;

				for (int i=0; i<n; i++) {
					if ((x & mask) != 0) {
						if (parity == 1) x &= ~mask;
						parity ^= 1;
					}
					mask <<= 1;
				}
				System.out.print(" " + x);
			}
			System.out.println();
		}
	}
}
