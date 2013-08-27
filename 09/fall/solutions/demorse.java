import java.util.*;

class demorse {

	public static void main(String[] arguments) {

		Map<String,Character> table = new HashMap<String,Character>();
		table.put("*-", 'a');
		table.put("-***", 'b');
		table.put("-*-*", 'c');
		table.put("-**", 'd');
		table.put("*", 'e');
		table.put("**-*", 'f');
		table.put("--*", 'g');
		table.put("****", 'h');
		table.put("**", 'i');
		table.put("*---", 'j');
		table.put("-*-", 'k');
		table.put("*-**", 'l');
		table.put("--", 'm');
		table.put("-*", 'n');
		table.put("---", 'o');
		table.put("*--*", 'p');
		table.put("--*-", 'q');
		table.put("*-*", 'r');
		table.put("***", 's');
		table.put("-", 't');
		table.put("**-", 'u');
		table.put("***-", 'v');
		table.put("*--", 'w');
		table.put("-**-", 'x');
		table.put("-*--", 'y');
		table.put("--**", 'z');

		Scanner in = new Scanner(System.in);

		while (in.hasNextLine()) {
			Scanner line = new Scanner(in.nextLine()).useDelimiter("0000000");

			while (line.hasNext()) {
				Scanner word = new Scanner(line.next()).useDelimiter("000");

				while (word.hasNext()) {
					Scanner letter = new Scanner(word.next()).useDelimiter("0");
					StringBuffer code = new StringBuffer();

					while (letter.hasNext())
						switch (letter.next().length()) {
							case 1: code.append("*"); break;
							case 3: code.append("-"); break;
						}
					char c = table.get(code.toString());
					System.out.print(c);
				}
				if (line.hasNext()) System.out.print(' ');
			}
			System.out.println();
		}
	}
}
