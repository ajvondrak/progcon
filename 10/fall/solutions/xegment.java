import java.util.Scanner;

class xegment {

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);

		while (in.hasNext()) {

			long xend = in.nextLong();
			long yend = in.nextLong();
			long count = 0;

			for (int x = 0, y = 0; x < xend && y < yend;) {
//				System.out.printf("(%d,%d)%n", x, y);
				count++;

				boolean xinc = (y+1) * xend >= (x+1) * yend;
				boolean yinc = (y+1) * xend <= (x+1) * yend;
				if (xinc) x++;
				if (yinc) y++;
			}
			System.out.printf("%d pixels%n", count);
		}
	}
}
