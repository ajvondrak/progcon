import java.util.*;

class rolling_odds {

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);

		while (in.hasNextInt()) {

			int[] h = new int[3]; // roll history, element 0 indicates no roll yet

			for (int rolls = 0; rolls <= 3; rolls++) {

				if (rolls > 0)
					h[rolls-1] = in.nextInt();

				if (rolls < 2)
					System.out.println("5/9 5/12 1/36");
				else if (rolls == 2)
					if (h[0] == h[1])
						System.out.println("0/1 5/6 1/6");
					else
						System.out.println("2/3 1/3 0/1");
				else // rolls == 3
					if (h[0] == h[1] && h[1] == h[2])
						System.out.println("0/1 0/1 1/1");
					else if (h[0] == h[1] || h[0] == h[2] || h[1] == h[2])
						System.out.println("0/1 1/1 0/1");
					else
						System.out.println("1/1 0/1 0/1");
			}
			System.out.println();
		}
	}
}
