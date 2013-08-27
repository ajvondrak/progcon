import java.util.*;

class ack_attack {

	private static Map<String,List<String>> tree = new HashMap<String,List<String>>(); // authority tree
	private static Map<String,Integer> leaves = new HashMap<String,Integer>(); // node -> #leaves mapping

	private static int leaves(String node) {

		int count = 0;
		List<String> children = tree.get(node);

		if (children.isEmpty())
			count = 1;
		else
			for (String child : children)
				count += leaves(child);

		leaves.put(node, count);
		return count;
	}

	private static void copies(String node, int depth) {

		int count;
		List<String> children = tree.get(node);

		if (depth == 0)
			count = 0;
		else if (children.isEmpty())
			count = depth;
		else
			count = leaves.get(node) * (depth+1);

		System.out.printf("%d copies stored at %s%n", count, node);

		for (String child : children)
			copies(child, depth+1);
	}

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);

		while (in.hasNextLine()) {
			String root = null;
			Scanner line;

			while ((line = new Scanner(in.nextLine())).hasNext()) {
				String parent = line.next();
				List<String> children = new ArrayList<String>();

				while (line.hasNext())
					children.add(line.next());

				tree.put(parent, children);
				if (root == null) root = parent;
			}
			leaves(root);
			copies(root, 0);
			System.out.println();
		}
	}
}
