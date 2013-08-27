import java.math.BigInteger;
import java.util.Scanner;

class power_search {

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);

		while (in.hasNextBigInteger()) {
			BigInteger a = in.nextBigInteger();
			BigInteger b = in.nextBigInteger();
			BigInteger ab = a.multiply(b);
			BigInteger i = BigInteger.ZERO;
			BigInteger bi = BigInteger.ONE;

			while (! (a.compareTo(bi) <= 0 && bi.compareTo(ab) < 0)) {
				i = i.add(BigInteger.ONE);
				bi = bi.multiply(b);
			}
			System.out.printf("%d <= %d^%d = %d < %d*%d = %d%n", a, b, i, bi, a, b, ab);
		}
	}
}
