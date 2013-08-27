import java.util.Scanner;

class zipper {

	private static String left, right, center;
	private static int llength, rlength, clength;

	private static boolean zip(int l, int r, int c) {

		char lchar = l == llength ? 0 : left.charAt(l);
		char rchar = r == rlength ? 0 : right.charAt(r);
		char cchar = c == clength ? 0 : center.charAt(c);
		return c == clength || lchar == cchar && zip(l+1, r, c+1) || rchar == cchar && zip(l, r+1, c+1);
	}

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);

		while (in.hasNext()) {
			left = in.next();
			right = in.next();
			center = in.next();

			llength = left.length();
			rlength = right.length();
			clength = center.length();

			System.out.printf("%3s: %s ~ %s =? %s%n",
				llength + rlength == clength && zip(0, 0, 0) ? "yes" : "no", left, right, center);
		}
	}
}
