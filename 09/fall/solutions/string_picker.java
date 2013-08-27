import java.util.Scanner;
import java.math.BigInteger;

class string_picker {

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);

		while (in.hasNext()) {
			String x = in.next();
			String y = in.next();

			// two-dimensional dynamic programming array
			// count[i][j] is number of occurrences of x[i:] in y[j:]
			BigInteger[][] count = new BigInteger[x.length()+1][y.length()+1];

			// initialize counts for basic case (i.e. empty suffix of x)
			for (int i = x.length(); i >= 0; i--)
				for (int j = y.length(); j >= 0; j--)
					count[i][j] = (i == x.length()) ? BigInteger.ONE : BigInteger.ZERO;

			// iteratively compute counts from prior (more basic) cases
			for (int i = x.length()-1; i >= 0; i--) // traverse x from right-to-left
				for (int j = y.length()-1; j >= 0; j--) { // traverse y from right-to-left

					count[i][j] = count[i][j+1]; // count occurrences of x[i:] in y[(j+1):]

					if (x.charAt(i) == y.charAt(j)) // if x[i] == y[j],
						count[i][j] = count[i][j].add(count[i+1][j+1]); // add occurrences of x[(i+1):] in y[(j+1):]
				}
			System.out.printf("%d \"%s\" in \"%s\"%n", count[0][0], x, y); // occurrences of x in y
		}
	}
}
