package renaming;

import java.io.File;
import java.io.IOException;

public class FileOps {
	public static File folder = new File(
			"C:\\Users\\N\\Desktop\\New folder\\RenamingFiles\\src\\renaming\\Files");
	public static File[] listOfFiles = folder.listFiles();

	public static void main(String[] argv) throws IOException {

	}

	public static void toUpperCase() {
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				String name = null;
				int value = 1;
				for (int j = 0; j < listOfFiles[i].getName().length(); j++) {
					if (value == 1) {
						name += Character.toLowerCase(listOfFiles[i].getName()
								.charAt(j));
						value = 2;
					}
					if (value == 2) {
						name += Character.toUpperCase(listOfFiles[i].getName()
								.charAt(j));
						value = 1;
					}
				}
				if (listOfFiles[i].renameTo(new File(folder,name))) {
					System.out.println("Done");
					
				} else {
					System.out.println("Nope");
				}
			}
		}
	}
}
