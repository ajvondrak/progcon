import java.util.*;

class word_wrap {

	private static final Scanner in = new Scanner(System.in);
	private static final int target_length = in.nextInt();
	private static final List<String> words = new ArrayList<String>();
	private static final int n;

	static {
		while (in.hasNext())
			words.add(in.next());
		n = words.size();
	}

	private static int line_badness(int left, int right) {
		int length = right - left; // number of blanks in line

		for (int i = left; i <= right; i++) // include word lengths in line
			length += words.get(i-1).length();

		return Math.abs(target_length - length);
	}

	public static void main(String[] arguments) {

		int[] badness = new int[n+1]; // badness[k] is minimum badness when wrapping 1st through kth words
		badness[0] = 0;

		int[] last_wrap = new int[n+1];

		for (int k = 1; k <= n; k++) { // compute badness[k]
			badness[k] = Integer.MAX_VALUE;

			for (int j = 0; j < k; j++) { // consider last wrap positions
				int prospect = badness[j] + line_badness(j+1, k);
				if (prospect < badness[k]) {
					badness[k] = prospect;
					last_wrap[k] = j;
				}
			}
		}

		System.out.printf("total badness: %d%n%n", badness[n]);

		Stack<Integer> wrap = new Stack<Integer>();
		wrap.push(n); // output newline after nth word

		for (int k = n; k > 0;)
			wrap.push(k = last_wrap[k]);
		wrap.pop(); // don't output newline after 0th word

		for (int k = 1; k <= n; k++) {
			System.out.print(words.get(k-1)); // output kth word

			if (wrap.peek() == k) {
				System.out.println(); // output newline after kth word
				wrap.pop();
			}
			else
				System.out.print(' '); // output blank after kth word
		}
	}
}
