import java.util.Scanner;

class anamorphic {

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);

		while (in.hasNextLong()) {
			long w_in = in.nextLong();
			long h_in = in.nextLong();
			long w_dev = in.nextLong();
			long h_dev = in.nextLong();
			long w_out;
			long h_out;

			if (w_in * h_dev >= w_dev * h_in) {
//System.out.printf("%d >= %d%n", w_in * h_dev, w_dev * h_in);
//System.out.printf("w_out = w_dev = %d%n", w_dev);
				w_out = w_dev;
//System.out.printf("h_out = h_in * w_out / w_in = %d / %d%n", h_in * w_out, w_in);
				h_out = h_in * w_out / w_in;
			}
			else {
//System.out.printf("%d < %d%n", w_in * h_dev, w_dev * h_in);
//System.out.printf("h_out = h_dev = %d%n", h_dev);
				h_out = h_dev;
//System.out.printf("w_out = w_in * h_out / h_in = %d / %d%n", w_in * h_out, h_in);
				w_out = w_in * h_out / h_in;
			}
			System.out.printf("w x h = %d x %d pixels%n", w_out, h_out);
		}
	}
}
