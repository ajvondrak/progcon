import java.util.*;

class flush {


	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);

		SortedMap<Integer,List<Integer>> adjacent = new TreeMap<Integer,List<Integer>>();

		while (true) {
			Scanner line = new Scanner(in.nextLine());
			if (! line.hasNextInt()) break;
			int from = line.nextInt();
			List<Integer> to = new ArrayList<Integer>();
			while (line.hasNextInt()) to.add(line.nextInt());
			adjacent.put(from, to);
		}
		while (in.hasNextDouble()) {
			double rootAmount = in.nextDouble();
			int root = in.nextInt();

			Map<Integer,Double> accepted = new HashMap<Integer,Double>();
			Map<Integer,Integer> parent = new HashMap<Integer,Integer>();
			Queue<Integer> queue = new LinkedList<Integer>();

			accepted.put(root, rootAmount);
			parent.put(root, null);
			queue.offer(root);

			while (! queue.isEmpty()) {
				int from = queue.remove();
				double inAmount = accepted.get(from);
				int toDegree = 0;

				for (Integer to : adjacent.get(from))
					if (accepted.get(to) == null) toDegree++;

				for (Integer to : adjacent.get(from))

					if (accepted.get(to) == null) {
						accepted.put(to, inAmount/toDegree);
						parent.put(to, from);
						queue.offer(to);
					}
			}
			for (Integer to : adjacent.keySet()) {
				System.out.printf("%d accepts ", to);
				Double inAmount = accepted.get(to);

				if (inAmount == null)
					System.out.print("nothing");
				else {
					System.out.printf("%.2f", inAmount);
					Integer from = parent.get(to);
					if (from != null) System.out.printf(" from %d", from);
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
