package renaming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.commons.io.FilenameUtils;

public class FileOps {
	public static File folder = new File(
			"C:\\Users\\N\\Desktop\\New folder\\RenamingFiles\\src\\renaming\\Files");
	public static File[] listOfFiles = folder.listFiles();

	public static void main(String[] argv) throws IOException {
		toUpperCase();

	}

	public static void toUpperCase() throws IOException {
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
						rewrite(renamedFile.getAbsoluteFile());

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

	public static void rewrite(File file) throws IOException {
		FileReader reader = null;
		BufferedReader inFile = null;

		try {
			reader = new FileReader(file.getAbsolutePath());
			inFile = new BufferedReader(reader);
			FileWriter fwriter = new FileWriter(file.getAbsolutePath());
			BufferedWriter outw = new BufferedWriter(fwriter);

			while (inFile.readLine() != null) {
				String line = mixCase(inFile.readLine());
				outw.write(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inFile != null)
				inFile.close();

			if (reader != null)
				reader.close();
		}

	}
}