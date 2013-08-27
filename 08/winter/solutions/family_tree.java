import java.util.*;

class family_tree {

	private static final Map<String,List<String>> children = new HashMap<String,List<String>>();
	private static final Map<String,List<String>> parents = new HashMap<String,List<String>>();

	private static Set<String> descendants(String person) {

		Set<String> descendants = new HashSet<String>();
		List<String> l = children.get(person);
		if (l != null) {
			descendants.addAll(l);
			for (String child : l)
				descendants.addAll(descendants(child));
		}
		return descendants;
	}

	private static Set<String> ancestors(String person) {

		Set<String> ancestors = new HashSet<String>();
		List<String> l = parents.get(person);
		if (l != null) {
			ancestors.addAll(l);
			for (String parent : l)
				ancestors.addAll(ancestors(parent));
		}
		return ancestors;
	}

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);

		while (in.hasNextLine()) {

			Scanner line = new Scanner(in.nextLine());

			if (! line.hasNext()) break;

			String father = line.next();
			String mother = line.next();
			String child = line.next();

			List<String> l;

			l = children.get(father);
			if (l == null) l = new LinkedList<String>();
			l.add(child);
			children.put(father, l);

			l = children.get(mother);
			if (l == null) l = new LinkedList<String>();
			l.add(child);
			children.put(mother, l);

			l = new LinkedList<String>();
			l.add(father);
			l.add(mother);
			parents.put(child, l);
		}
		while (in.hasNext()) {

			String person = in.next();
			System.out.printf("%s has %d descendants and %d ancestors%n",
				person, descendants(person).size(), ancestors(person).size());
		}
	}
}
