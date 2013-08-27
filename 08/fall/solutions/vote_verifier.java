import java.util.*;

class vote_verifier {

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[] candidate = new int[n];

		while (in.hasNextInt()) {

			int index = in.nextInt();
			int cipher = in.nextInt();
			int key = in.nextInt();
			String plain = "";

			for (int i = n; --i >= 0;) {
				candidate[i] = ((cipher % 10) + (key % 10)) % 10;
				plain = candidate[i] + plain;
				cipher /= 10;
				key /= 10;
			}
			System.out.printf("plaintext ballot: %s  index: %d  vote for candidate: %d%n", plain, index, candidate[index-1]);
		}
	}
}
