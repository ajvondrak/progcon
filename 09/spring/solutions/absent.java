import java.util.*;

class absent {

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);
		Queue<String> queue = new LinkedList<String>();

		next: while (in.hasNextLine()) {
			String host = in.nextLine();
			queue.clear();
			queue.add("");

			while (true) {
				String prefix = queue.remove();

				for (char c = 'a'; c <= 'c'; c++) {
					String substring = prefix + c;
					if (host.contains(substring))
						queue.add(substring);
					else {
						System.out.printf("%s is absent from %s%n", substring, host);
						continue next;
					}
				}
			}
		}
	}
}
