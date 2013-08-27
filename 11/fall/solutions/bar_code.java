import java.util.*;

class bar_code {

	public static void main(String[] arguments) {

		Scanner in = new Scanner(System.in);
		Map<Integer,Integer> inventory = new HashMap<Integer,Integer>();
		int n = in.nextInt();

		for (int i=0; i<n; i++)
			inventory.put(in.nextInt(8), in.nextInt());

		int total_quantity = 0;
		int total_cost = 0;

		while (in.hasNextInt()) {
			int quantity = in.nextInt();
			int code = in.nextInt(2);

			if (! inventory.containsKey(code))
				System.out.printf("item %08o not in inventory%n", code);
			else {
				total_quantity += quantity;
				total_cost += quantity * inventory.get(code);
			}
		}
		System.out.printf("deliver %d items from inventory, total cost = $%d%n", total_quantity, total_cost);
	}
}
