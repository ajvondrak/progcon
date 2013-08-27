import java.util.Scanner;

class run_of_a_kind {

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);

		while (in.hasNextLine()) {
			String line           = in.nextLine().toLowerCase().replaceAll("[^ht]", "");
			int    last           = -1;
			int[]  run_length     = new int[2];
			int[]  run_start      = new int[2];
			int[]  max_run_length = new int[2];
			int[]  max_run_start  = new int[2];

			for (int i = 0; i < line.length(); i++) {
				int flip = line.charAt(i) == 'h' ? 1 : 0;

				if (flip == last)
					run_length[flip]++;
				else {
					run_length[flip] = 1;
					run_start[flip] = i;
				}
				if (run_length[flip] > max_run_length[flip]) {
					max_run_length[flip] = run_length[flip];
					max_run_start[flip] = run_start[flip];
				}
				last = flip;
			}
			for (int i = 0; i < line.length(); i++) {
				char flip = line.charAt(i);

				if (max_run_start[0] <= i && i <= max_run_start[0]+max_run_length[0]-1 ||
				    max_run_start[1] <= i && i <= max_run_start[1]+max_run_length[1]-1)
					flip = Character.toUpperCase(flip);

				System.out.print(flip);
			}
			System.out.println();
			System.out.printf("longest run of heads is %d%n", max_run_length[1]);
			System.out.printf("longest run of tails is %d%n%n", max_run_length[0]);
		}
	}
}
