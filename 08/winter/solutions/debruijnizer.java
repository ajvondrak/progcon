import java.util.Scanner;

class debruijnizer {

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);

		while (in.hasNextInt()) {

			int k = in.nextInt();
			int n = in.nextInt();
			String debruijn = "";

			for (int i = 0; i < n; i++)
				debruijn += '0';

			outer: while (true) {

				for (char c = (char)('0'+k); --c >= '0';) {

					String suffix = debruijn.substring(debruijn.length()-(n-1)) + c;

					if (! debruijn.contains(suffix)) {
						debruijn += c;
						continue outer;
					}
				}
				break;
			}
			System.out.println(debruijn);
		}
	}
}
