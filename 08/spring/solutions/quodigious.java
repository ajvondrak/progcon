import java.util.Scanner;

class quodigious {

	private static boolean magic(int x, int length) {

		int remainder = x;
		int sum = 0;
		int product = 1;

		for (int i = 0; i < length; i++) {
			int digit = remainder % 10;
			if (digit <= 1) return false;
			sum += digit;
			product *= digit;
			remainder /= 10;
		}
		return remainder == 0 && x % sum == 0 && x % product == 0;
	}

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);

		while (in.hasNextInt()) {
			int length = in.nextInt();
			int max = 1; for (int l = 0; l < length; l++) max *= 10;

			for (int x = max/10; x < max; x++)
				if (magic(x, length)) System.out.println(x);

			System.out.println();
		}
	}
}
