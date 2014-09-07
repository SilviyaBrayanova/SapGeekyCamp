package nmishewa.geekycamp.dictionary;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static File file = new File(
			"C:\\Users\\N\\Desktop\\New folder\\Dictionary\\src\\nmishewa\\geekycamp\\dictionary\\bg_win1251.txt");
	public static int value = 1;
	private static Scanner input;
	public static Scanner in = new Scanner(System.in);
	public static Map<String, Integer> map = new HashMap<String, Integer>();

	public static void main(String[] args) throws FileNotFoundException {
		readFile();
		System.out.println("Enter number of function wanted" + "\n1 to add"
				+ "\n2 for searching by prefix" + "\n3 for deleting");
		int choice = in.nextInt();
		if (choice == 1) {
			System.out.println("enter wordS seprated by comma");
			String wd = in.next();
			add(wd);
		}
		if (choice == 2) {
			System.out.println("Enter prefix");
			String wd = in.next();
			prefixSearch(wd);
		}
		if (choice == 3) {
			System.out.println("ENTER wordS to delete seprated by comma");
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
			// puts words in the array
			for (int j = 0; j < line.length; j++) {
				//iterrate troght the array of new words
				map.put(line[j], value);
				// put every word in it the map
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
		/*O(N)*/
		for (Map.Entry<String, Integer> key : map.entrySet()) {
			//iterrate trough the map enterySet
			if (key.getKey().startsWith(prefix)) {
				// see if the current key starts with current prefix
				System.out.println(key.getKey());
				
			}
		}

	}

	public static void add(String wd) {
		boolean done = false;
		String word = wd.toLowerCase();
		String[] line = word.split("[,\\s]+");
		/*linear O(N)*/
		for (int j = 0; j < line.length; j++) {
			//iterrate trough the array with words
			if (!map.containsKey(line[j])) {
				//check if there isn't already such word
				map.put(line[j], value);
				// add it to the map if not exisitng				
				value++;
				//Writing it in the file by FileWriter and BufferedWriter
				try {
					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(map.toString());
					bw.close();
					done = true;
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {// if the word exist skip it
				continue;
			}
		}

		if (done == true) {
			System.out.println("Success");
		}

	}

	public static void remove(String wd) {
		boolean done = false;
		String word = wd.toLowerCase();
		String[] line = word.split("[,\\s]+");
		/*Linear O(N)*/
		for (int j = 0; j < line.length; j++) {
			// iterrate trough the array 
			map.remove(line[j]);
			//remove every word[i] from the map
		}
		// write it in the file
		try {
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(map.toString());
			bw.close();
			done = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (done == true) {
			System.out.println("Success");
		}
	}

}
