import java.util.*;

class overload {

	private static Map<String, String> parents = new HashMap<String, String>();

	private static boolean ancestor(String name1, String name2) {
		if (name1.equals(name2))
			return true;
		else if (! parents.containsKey(name2))
			return false;
		else
			return ancestor(name1, parents.get(name2));
	}

	private static class Signature {
		private String line;
		private String result;
		private String name;
		private String[] arguments;

		private Signature(String line) {
			this.line = line;
			Scanner token = new Scanner(line).useDelimiter("[(),\\s]+");
			this.result = token.next();
			this.name = token.next();
			this.arguments = token.delimiter().split(token.nextLine());
		}

		private boolean matches(Signature formal) {
			if (! name.equals(formal.name)) return false;
			if (arguments.length != formal.arguments.length) return false;
			if (! ancestor(result, formal.result)) return false;

			for (int i = 1; i < arguments.length; i++)
				if (! ancestor(formal.arguments[i], arguments[i])) return false;
			return true;
		}

		public String toString() {
			return line;
		}
	}

	public static void main(String[] arguments) {
		Scanner in = new Scanner(System.in);

		while (true) {
			String line = in.nextLine();
			if (line.length() == 0) break;
			Scanner token = new Scanner(line);
			String child = token.next();
			token.next(); // throw away "extends"
			String parent = token.next();
			parents.put(child, parent);
		}
		List<Signature> formals = new ArrayList<Signature>();

		while (true) {
			String line = in.nextLine();
			if (line.length() == 0) break;
			formals.add(new Signature(line));
		}
		while (in.hasNextLine()) {
			Signature actual = new Signature(in.nextLine());
			System.out.printf("actual: %s%n", actual);

			for (Signature formal : formals)
				if (actual.matches(formal))
					System.out.printf("formal: %s%n", formal);

			System.out.println();
		}
	}
}
