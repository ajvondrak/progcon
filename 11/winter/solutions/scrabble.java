import java.util.Scanner;

class scrabble {

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);

		int[] value = new int[256];
		for (char c='a'; c<='z'; c++) value[c] = in.nextInt();

		while (in.hasNextInt()) {
			int n = in.nextInt(); in.nextLine();
			System.out.printf("%dx%d board:%n", n, n);

			int[][] lmult = new int[n][n];
			for (int x=0; x<n; x++) for (int y=0; y<n; y++) lmult[x][y] = 1;
			int[][] wmult = new int[n][n];
			for (int x=0; x<n; x++) for (int y=0; y<n; y++) wmult[x][y] = 1;

			Scanner line = new Scanner(in.nextLine());
			while (line.hasNextInt()) lmult[line.nextInt()][line.nextInt()] = 2;

			line = new Scanner(in.nextLine());
			while (line.hasNextInt()) lmult[line.nextInt()][line.nextInt()] = 3;

			line = new Scanner(in.nextLine());
			while (line.hasNextInt()) wmult[line.nextInt()][line.nextInt()] = 2;

			line = new Scanner(in.nextLine());
			while (line.hasNextInt()) wmult[line.nextInt()][line.nextInt()] = 3;

			while (true) {
				line = new Scanner(in.nextLine());
				if (! line.hasNext()) break;

				String word = line.next();
				int x = line.nextInt();
				int y = line.nextInt();
				String direction = line.next();
				System.out.printf("%s at (%d,%d) %s scores ", word, x, y, direction);

				int score = 0;
				int word_multiplier = 1;
				int delta_x = direction.equals("across") ? +1 : 0;
				int delta_y = direction.equals("down")   ? -1 : 0;

				for (int i=0; i<word.length(); i++) {
					score += value[word.charAt(i)] * lmult[x][y];
					word_multiplier *= wmult[x][y];
					x += delta_x;
					y += delta_y;
				}
				System.out.println(score * word_multiplier);
			}
			System.out.println();
		}
	}
}
