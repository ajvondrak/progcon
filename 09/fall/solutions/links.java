import java.util.Scanner;

class links {

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);

		while (in.hasNext()) {
			int[] refs = new int[128];
			char[] succ = new char[128];

			for (char c = 0; c < 128; c++) {
				refs[c] = -1; // c has not appeared
				succ[c] = 0; // c has no successor
			}
			while (in.hasNextLine()) {
				Scanner line = new Scanner(in.nextLine());
				if (! line.hasNext()) break; // empty line

				while (line.hasNext()) {
					char a = line.next().charAt(0);
					if (refs[a] == -1) refs[a] = 0; // a first appears without predecessors
					if (succ[a] != 0) refs[succ[a]]--; // a has successor, which loses predecessor a

					char b = line.next().charAt(0);
					if (refs[b] == -1) refs[b] = 0; // b appears without predecessors
					refs[b]++; // b gains predecessor a
					succ[a] = b; // a precedes b
				}
			}
			long num_lists = 0; // count lists traversed
			long all_vertices = 0; // count vertices in all lists

			next_list: for (char h = 0; h < 128; h++)

				if (refs[h] == 0) { // h is head of list
					long vertices = 1; // count vertices in this list

					for (char c = h; succ[c] != 0; c = succ[c]) { // traverse list
						vertices++;
						if (vertices > 128) continue next_list; // stuck in a cycle, not a list
					}
					num_lists++;
					all_vertices += vertices;
				}
			if (num_lists == 0)
				System.out.printf("%d lists%n", num_lists);
			else 
				System.out.printf("%d lists averaging %.2f vertices%n", num_lists, (double)all_vertices/num_lists);
		}
	}
}
