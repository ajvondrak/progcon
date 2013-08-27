import java.util.Scanner;

class rack_em_up {

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);

		while (in.hasNextInt()) {

			int[] score = new int[10];
			int total = 0;

			for (int i = 0; i < 10; i++) {

				int pins = in.nextInt();
				int tries = 1;

				if (pins < 10) {
					pins += in.nextInt();
					tries++;
				}
				score[i] = pins;
				if (pins == 10 && i >= 1) score[i] += score[i-1];
				if (pins == 10 && tries == 1 && i >= 2) score[i] += score[i-2];

				System.out.printf("%5d", score[i]);
				total += score[i];
			}
			System.out.printf(" = %5d%n", total);
		}
	}
}
