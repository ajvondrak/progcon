import java.util.*;

class disorder {

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);

		while (in.hasNext()) {
			List<String> lexical = new ArrayList<String>();

			while (in.hasNextLine()) {
				String s = in.nextLine();
				if (s.length() == 0) break;
				lexical.add(s);	
			}

			List<String> dictionary = new ArrayList<String>(lexical);

			Collections.sort(lexical, new Comparator<String>() {

				public int compare(String s1, String s2) {
					if (s1.length() != s2.length()) return s1.length() - s2.length();
					return s1.compareTo(s2);
				}
			});

			Collections.sort(dictionary);

			int distance = 0;

			for (int i = 0; i < lexical.size(); i++)
				distance += Math.abs(i - dictionary.indexOf(lexical.get(i)));

			System.out.println(distance);
		}
	}
}
