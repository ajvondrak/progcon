import java.util.*;

class huffman_code {

	private static int[] freq = new int[127];

	private static class Tree implements Comparable<Tree> {

		char c;
		int weight;
		Tree left;
		Tree right;

		Tree(char c, int weight, Tree left, Tree right) {
			this.c = c;
			this.weight = weight;
			this.left = left;
			this.right = right;
		}

		public int compareTo(Tree to) {
			if (weight != to.weight) return weight - to.weight;
			return c - to.c;
		}
	}

	private static void encode(String prefix, Tree tree) {
		if (tree.left == null && tree.right == null)
			System.out.printf("%c %s (%d)%n", tree.c, prefix, freq[tree.c]);
		else {
			encode(prefix + "0", tree.left);
			encode(prefix + "1", tree.right);
		}
	}

	public static void main(String[] arguments) throws java.io.IOException {

		PriorityQueue<Tree> queue = new PriorityQueue<Tree>();

		for (int c; (c = System.in.read()) != -1;)
			if (32 <= c && c <= 126) freq[c]++;

		for (char c = 32; c <= 126; c++)
			if (freq[c] > 0) queue.offer(new Tree(c, freq[c], null, null));

		while (queue.size() > 1) {
			Tree left = queue.remove();
			Tree right = queue.remove();
			queue.offer(new Tree((char)Math.min(left.c, right.c), left.weight + right.weight, left, right));
		}
		if (queue.size() > 0) encode("", queue.remove());
	}
}
