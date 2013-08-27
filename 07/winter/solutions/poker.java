import java.util.Scanner;

class poker {

	private static final Scanner in = new Scanner(System.in);

	private final int[] value = new int[15];
	private final int[] suit = new int[4];

	poker() {
		for (int i = 1; i <= 5; i++) {
			String card = in.next();

			char v = Character.toUpperCase(card.charAt(0));
			switch (v) {
				default:  value[v-'0']++; break;
				case 'T': value[10]++; break;
				case 'J': value[11]++; break;
				case 'Q': value[12]++; break;
				case 'K': value[13]++; break;
				case 'A': value[14]++; break;
			}
			char s = Character.toUpperCase(card.charAt(1));
			switch (s) {
				case 'D': suit[0]++; break;
				case 'C': suit[1]++; break;
				case 'H': suit[2]++; break;
				case 'S': suit[3]++; break;
			}
		}
	}

	private int score() {
		int kind1 = 0, kind2 = 0, kind3 = 0, kind4 = 0, run = 0, hand = 0;
		boolean flush = false;

		for (int v = 14; v >= 2; v--) {
			     if (value[v] == 1) {kind1 <<= 4; kind1 |= v;}
			else if (value[v] == 2) {kind2 <<= 4; kind2 |= v;}
			else if (value[v] == 3) {kind3 <<= 4; kind3 |= v;}
			else if (value[v] == 4) {kind4 <<= 4; kind4 |= v;}
			if (value[v] == 1) {
				     if (run == 0)        run = 1;
				else if (value[v+1] == 1) run++;
				else if (run < 5)         run = 0;
			}
			else {
				     if (run < 5)         run = 0;
			}
		}
		for (int s = 0; s < 4; s++)
			if (suit[s] == 5) flush = true;

		     if (run == 5 && flush)            hand = 8;
		else if (kind4 > 0x00)                 hand = 7;
		else if (kind3 > 0x00 && kind2 > 0x00) hand = 6;
		else if (flush)                        hand = 5;
		else if (run == 5)                     hand = 4;
		else if (kind3 > 0x00)                 hand = 3;
		else if (kind2 > 0x10)                 hand = 2;
		else if (kind2 > 0x00)                 hand = 1;

		return hand << 20 | kind4 << 16 | kind3 << 16 | kind2 << 12 | kind1;
	}

	public String toString() {
		switch (score() >>> 20) {
			case 0: return "high card";
			case 1: return "one pair";
			case 2: return "two pairs";
			case 3: return "three of a kind";
			case 4: return "straight";
			case 5: return "flush";
			case 6: return "full house";
			case 7: return "four of a kind";
			case 8: return "straight flush";
		}
		return "";
	}

	public static void main(String[] arguments) {
		while (in.hasNext()) {
			poker first = new poker(), second = new poker();
			switch (Integer.signum(first.score() - second.score())) {
				case -1 : System.out.printf("%s loses to %s%n", first, second); break;
				case 0 : System.out.printf("%s ties %s%n", first, second); break;
				case 1 : System.out.printf("%s beats %s%n", first, second); break;
			}
		}
	}
}
