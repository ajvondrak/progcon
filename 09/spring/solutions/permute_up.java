import java.util.*;

class permute_up {

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);

		while (in.hasNext()) {

			String x = in.next();
			System.out.printf("%s -> ", x);
			char[] c = x.toCharArray();

			int l;
			for (l = c.length-1; --l >= 0;)
				if (c[l] < c[l+1]) break;

			if (l < 0)
				System.out.println("no successor");
			else {
				int r;
				for (r = l+1; r < c.length; r++)
					if (c[r] <= c[l]) break;

				char temp = c[l];
				c[l] = c[r-1];
				c[r-1] = temp;

				Arrays.sort(c, l+1, c.length);
				System.out.println(new String(c));
			}
		}
	}
}
