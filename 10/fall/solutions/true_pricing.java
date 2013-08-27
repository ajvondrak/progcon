import java.util.Scanner;

class true_pricing {

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);

		while (in.hasNextLine()) {
			Scanner line = new Scanner(in.nextLine());

			long true_price = line.nextLong();
			double taxes = 0;

			while (line.hasNextDouble())
				taxes += line.nextDouble() / 100;

			System.out.printf("%.2f%n", true_price / (1 + taxes));
		}
	}
}
