import java.util.*;

class detassel {

	static class Attachment {

		boolean tassel;
		double yLo;
		double yHi;
		double r;

		Attachment(boolean tassel, double y, double theta, double r) {
			this.tassel = tassel;
			this.yLo = y;
			this.yHi = y + r * Math.sin(theta * Math.PI / 180);
			this.r = r;
		}
	}

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);
		List<Attachment> attached = new ArrayList<Attachment>();

		while (true) {
			Scanner line = new Scanner(in.nextLine());
			if (! line.hasNext()) break;

			attached.add(new Attachment(
				line.next().equals("t"),
				line.nextDouble(), // y > 0;
				line.nextDouble(), // 0 < theta < 180
				line.nextDouble() // r > 0;
			));
		}
		while (in.hasNextDouble()) {
			double yCut = in.nextDouble();
			double tError = 0;
			double lError = 0;

			for (Attachment a : attached) {
				boolean tassel = a.tassel;
				double yLo = a.yLo;
				double yHi = a.yHi;
				double r = a.r;

				if (  tassel && yLo < yCut) tError += r * (Math.min(yCut, yHi)-yLo) / (yHi-yLo);
				if (! tassel && yHi > yCut) lError += r * (yHi-Math.max(yCut, yLo)) / (yHi-yLo);
			}
			System.out.printf("cut %.2f produces tassel error %.2f and ear/leaf error %.2f%n", yCut, tError, lError);
		}
	}
}
