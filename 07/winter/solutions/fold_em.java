import java.util.Scanner;

class fold_em {

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);

		while (in.hasNext()) {
			double w = in.nextDouble();
			double h = in.nextDouble();
			int from = in.nextInt();
			int to = in.nextInt();
			double fold = 0;

			switch (from ^ to) {
				case 0: System.out.println("fold invalid"); continue;
				case 1: fold = w; break;
				case 2: fold = h; break;
				case 3: fold = Math.min(h,w) * Math.sqrt(h*h + w*w) / Math.max(h,w); break;
			}
			System.out.printf("fold length: %.4f%n", fold);
		}
	}
}
