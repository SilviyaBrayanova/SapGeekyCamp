package nmishewa.geekycamp.dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static File file = new File(
			"C:\\Users\\N\\workspace\\Dictionary\\src\\nmishewa\\geekycamp\\dictionary\\bg_win1251.txt");
	public static int value = 1;
	private static Scanner input;
	public static Scanner in = new Scanner(System.in);
	public static Map<String, Integer> map = new HashMap<String, Integer>();

	public static void main(String[] args) throws FileNotFoundException {
		readFile();
		System.out.println("Enter number of function wanted" + "\n1 to add"
				+ "\n 2 for searching by prefix" + "\n for deleting");
		int choice = in.nextInt();
		if (choice == 1) {
			System.out.println("enter words seprated by comma");
			String wd = in.next();
			add(wd);
		}
		if (choice == 2) {
			System.out.println("Enter prefix");
			String wd = in.next();
			prefixSearch(wd);
		}
		if (choice == 3) {
			System.out.println("ENTER word to delete");
			String wd = in.next();
			remove(wd);
		}

	}

	public static void readFile() throws FileNotFoundException {
		input = new Scanner(file);
		boolean done = false;

		int value = 1;

		while (input.hasNext()) {
			String word = input.next().toLowerCase();
			String[] line = word.split("[,\\s]+");
			for (int j = 0; j < line.length; j++) {
				map.put(line[j], value);
				value++;
				done = true;
			}
		}
		if (done == true) {
			System.out.println("Succes");
		}
	}

	public static void prefixSearch(String wd) {
		System.out.println("Enter prefix");
		String prefix = wd.toLowerCase();
		for (Map.Entry<String, Integer> key : map.entrySet()) {
			if (key.getKey().startsWith(prefix)) {
				System.out.println(key.getKey());
			}
		}

	}

	public static void add(String wd) {
		boolean done = false;
		String word = wd.toLowerCase();
		String[] line = word.split("[,\\s]+");
		for (int j = 0; j < line.length; j++) {
			if (!map.containsKey(line[j])) {
				map.put(line[j], value);
				value++;
				done = true;
			} else {
				continue;
			}
		}

		if (done == true) {
			System.out.println("Succes");
		}

	}

	public static void remove(String wd) {
		System.out.println("Enter words you want to remove");
		boolean done = false;

		String word = wd.toLowerCase();
		String[] line = word.split("[,\\s]+");
		for (int j = 0; j < line.length; j++) {
			if (map.containsKey(line[j])) {
				map.remove(line[j], map.get(line[j]));
				value--;
				done = true;
			} else {
				continue;
			}
		}

		if (done == true) {
			System.out.println("Succes");
		}

	}
}
