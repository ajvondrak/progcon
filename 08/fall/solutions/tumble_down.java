import java.util.*;

class tumble_down {

	private static int n = 0;

	private static class Block implements Comparable<Block> {

		int x, y, w, h;
		int number;
		boolean supported;

		Block(int x, int y, int w, int h) {
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			this.number = ++n;
			this.supported = bottom() == 0;
		}

		int bottom() {return y;}
		int top() {return y+h;}
		int left() {return x;}
		int right() {return x+w;}
		double center() {return x+w/2.;}
		boolean leftSupports(Block b) {return b.bottom() == top() && b.left() < right() && b.center() > left();}
		boolean rightSupports(Block b) {return b.bottom() == top() && b.right() > left() && b.center() < right();}

		public int compareTo(Block to) {
			if (bottom() != to.bottom()) return bottom() - to.bottom();
			return number - to.number;
		}
	}

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);
		List<Block> blocks = new ArrayList<Block>();
		SortedSet<Block> sorted_blocks = new TreeSet<Block>();

		while (in.hasNextInt()) {
			Block b = new Block(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
			blocks.add(b);
			sorted_blocks.add(b);
		}
		for (Block over : sorted_blocks) {

			if (over.supported) continue; 
	
			boolean leftSupported = false, rightSupported = false;

			for (Block under : blocks) {
				if (! under.supported) continue;
				if (under.leftSupports(over)) leftSupported = true;
				if (under.rightSupports(over)) rightSupported = true;
			}
			if (leftSupported && rightSupported) over.supported = true;
		}
		for (Block b : blocks)
			System.out.printf("block %d is %ssupported%n", b.number, b.supported ? "" : "not ");
	}
}
