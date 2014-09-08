package renaming;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.io.FilenameUtils;

public class FileOps {
	public static File folder = new File(
			"C:\\Users\\N\\Desktop\\New folder\\RenamingFiles\\src\\renaming\\Files");
	public static File[] listOfFiles = folder.listFiles();

	public static void main(String[] argv) throws IOException {
		toUpperCase();

	}

	public static void toUpperCase() throws FileNotFoundException {
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				String newname = mixCase(listOfFiles[i].getName());
				File renamedFile = new File(folder, newname);

				if (listOfFiles[i].renameTo(renamedFile)) {
					String extension = FilenameUtils
							.getExtension(listOfFiles[i].getName());
					if (extension.equals("txt") || extension.equals("pdf")
							|| extension.equals("tXt")
							|| extension.equals("TxT")) {
						rewrite(renamedFile);

						System.out.println("Done");
					}

				}
			} else {
				System.out.println("Nope");
			}
		}
	}

	public static String mixCase(String in) {
		StringBuilder sb = new StringBuilder();
		if (in != null) {
			char[] arr = in.toCharArray();
			if (arr.length > 0) {
				char f = arr[0];
				boolean first = Character.isUpperCase(f);
				for (int i = 0; i < arr.length; i++) {
					sb.append((first) ? Character.toLowerCase(arr[i])
							: Character.toUpperCase(arr[i]));
					first = !first;
				}
			}
		}
		return sb.toString();
	}

	public static void rewrite(File file) throws FileNotFoundException {
		Scanner inFile = new Scanner(file);
		ArrayList<String> nfr = new ArrayList<String>();

		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream(file));
			while (inFile.hasNext()) {
				pw.println(mixCase(inFile.next()));

			}
			pw.close();

		} catch (IOException e) {
			e.printStackTrace();

		}
	}
}