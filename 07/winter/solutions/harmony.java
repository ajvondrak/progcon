import java.util.Scanner;

class harmony {

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);

		while (in.hasNextDouble()) {
			double root = in.nextDouble();

			System.out.printf("%n    equal   pythagorean%n");
			System.out.printf("%10.4f %10.4f%n", root,                       root       );
			System.out.printf("%10.4f%n",        root * Math.pow(2, 1/12.)              );
			System.out.printf("%10.4f%n",        root * Math.pow(2, 2/12.)              );
			System.out.printf("%10.4f %10.4f%n", root * Math.pow(2, 3/12.),  root * 6/5 );
			System.out.printf("%10.4f %10.4f%n", root * Math.pow(2, 4/12.),  root * 5/4 );
			System.out.printf("%10.4f %10.4f%n", root * Math.pow(2, 5/12.),  root * 4/3 );
			System.out.printf("%10.4f%n",        root * Math.pow(2, 6/12.)              );
			System.out.printf("%10.4f %10.4f%n", root * Math.pow(2, 7/12.),  root * 3/2 );
			System.out.printf("%10.4f %10.4f%n", root * Math.pow(2, 8/12.),  root * 8/5 );
			System.out.printf("%10.4f %10.4f%n", root * Math.pow(2, 9/12.),  root * 5/3 );
			System.out.printf("%10.4f%n",        root * Math.pow(2, 10/12.)             );
			System.out.printf("%10.4f%n",        root * Math.pow(2, 11/12.)             );
			System.out.printf("%10.4f %10.4f%n", root * 2,                   root * 2   );
		}
	}
}
