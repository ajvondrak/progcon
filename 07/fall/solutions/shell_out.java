import java.util.*;

class shell_out {

	private static final Scanner in = new Scanner(System.in);
	private static final int[] denomination = {25, 10, 5, 1};

	private static class Pile implements Comparable<Pile> {

		private final int player;
		private final int[] quantity = new int[4];

		Pile(int player, int[] initial) {
			this.player = player;
			for (int i = 0; i < 4; i++) quantity[i] = initial[i];
		}

		private int count() {
			int count = 0;
			for (int i = 0; i < 4; i++) count += quantity[i];
			return count;
		}

		private int amount() {

			int amount = 0;
			for (int i = 0; i < 4; i++) amount += quantity[i] * denomination[i];
			return amount;
		}

		private void give(int amount, Pile to) {
			for (int i = 0; i < 4; i++)
				while (amount >= denomination[i]) {
					if (quantity[i] == 0) break;

					quantity[i]--;
					to.quantity[i]++;
					amount -= denomination[i];
				}
		}

		public int compareTo(Pile p) {
			return p.amount() * p.count() - amount() * count();
		}

		public String toString() {
			return "player " + player + " score " + (count()*amount());
		}
	}

	public static void main(String[] arguments) {

		int n = in.nextInt();
		int[] initial = new int[4];
		for (int i = 0; i < 4; i++) initial[i] = in.nextInt();

		Pile[] chair = new Pile[n];
		Pile[] rank = new Pile[n];

		for (int p = 0; p < n; p++) chair[p] = rank[p] = new Pile(p+1, initial);

		while (in.hasNextInt()) {
			int winner = in.nextInt()-1;
			int amount = in.nextInt();

			for (int p = 0; p < n; p++)
				if (p != winner) chair[p].give(amount, chair[winner]);

			Arrays.sort(rank);

			for (Pile pile : rank) System.out.println(pile);
			System.out.println();
		}
	}
}
