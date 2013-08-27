import java.util.*;

class crap_streak {

	private static int score(List<Integer> rolls, int i, int j) {
		int score = 0;
		for (int k = i; k <= j; k++)
			score += rolls.get(k);
		return score;
	}

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);

		int[] value = new int[]{0,0,2,1,1,-1,-1,-1,-1,1,1,1,3};

		while (in.hasNextInt()) {
			List<Integer> rolls = new ArrayList<Integer>();

			int high = Integer.MIN_VALUE;
			List<Integer> start = new ArrayList<Integer>();
			List<Integer> end = new ArrayList<Integer>();

			while (true) {
				Scanner line = new Scanner(in.nextLine());
				if (! line.hasNextInt()) break;
				rolls.add(value[line.nextInt() + line.nextInt()]);
			}

			for (int i = 0; i < rolls.size(); i++)
				for (int j = i; j < rolls.size(); j++) {
					int score = score(rolls, i, j);

					if (score > high) {
						high = score;
						start.clear();
						end.clear();
					}
					if (score == high) {
						start.add(i);
						end.add(j);
					}
				}

			System.out.printf("best winning streak is $%d from rolls", high);

			for (int i = 0; i < start.size(); i++)
				System.out.printf(" %d-%d", start.get(i)+1, end.get(i)+1);
			System.out.println();
		}
	}
}
