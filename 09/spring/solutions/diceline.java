import java.util.*;

class diceline {

	private static char opposite(char direction) {
		switch (direction) {
			case 'N': return 'S';
			case 'E': return 'W';
			case 'S': return 'N';
			case 'W': return 'E';
			case 'U': return 'D';
			case 'D': return 'U';
			default: return 0;
		}
	}

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);

		while (in.hasNextInt()) {
			int n = in.nextInt(); in.nextLine();
			Map[] dice = new HashMap[n];
			for (int i = 0; i < n; i++) dice[i] = new HashMap();

			while (in.hasNextLine()) {
				Scanner line = new Scanner(in.nextLine()).useDelimiter("\\s*[:,]\\s*");
				if (! line.hasNext()) break;
				char direction = line.next().charAt(0);

				for (int i = 0; i < n; i++) {
					int value = line.nextInt();
					if (value == 0) continue; // no useful info
					Map die = dice[i];
					if (die == null) continue; // die was already inconsistent
					int old_value = die.containsKey(direction) ? (Integer)(die.get(direction)) : 0;
					if (value == old_value) continue; // new info is redundant
					if (die.containsValue(value) || old_value != 0) { // die is inconsistent
						dice[i] = null;
						continue;
					}
					die.put(direction, value);
					die.put(opposite(direction), 7-value);
				}
			}
			for (int i = 0; i < n; i++) {
				System.out.printf("die %d is ", i);
				Map die = dice[i];
				if (die == null)
					System.out.println("inconsistent");
				else if (die.size() == 6)
					System.out.println("known");
				else
					System.out.println("unknown");
			}
			System.out.println();
		}
	}
}
