import java.util.*;

class coin_hole {

	private static List<Integer> coins;
	private static boolean[] made;

	private static void descend(int i, int total) {

		if (i > 0) {
			made[total] = true;
			descend(i-1, total);

			total += coins.get(i-1);

			made[total] = true;
			descend(i-1, total);
		}
	}

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);

		while (in.hasNextLine()) {
			Scanner line  = new Scanner(in.nextLine());
			coins         = new ArrayList<Integer>();
			int total     = 0;

			while (line.hasNextInt()) {
				int coin = line.nextInt();
				coins.add(coin);
				total += coin;
			}

			made = new boolean[total+1];
			made[0] = true;
			descend(coins.size(), 0);

			int least_unmade = total+1;
			int number_unmade = 0;

			for (int amount = 0; amount <= total; amount++)
				if (! made[amount]) {
					number_unmade++;
					if (least_unmade > total) least_unmade = amount;
				}

			System.out.printf("the least amount that can't be made exactly is %d%n", least_unmade);
			System.out.printf("the number of amounts between 0 and %d that can't be made exactly is %d%n%n", total, number_unmade);
		}
	}
}
