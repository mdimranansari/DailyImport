import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.testng.annotations.Test;

public class ReadCSV {
	@Test
	public static  String[]  readCSV() throws FileNotFoundException,
			InterruptedException {
		// TODO Auto-generated method stub

		int i = 0;
		String[] s = new String[200];
		String[] s2 = new String[200];
		String csvFile = "./others/data.csv";
		File f = new File(csvFile);
		// if(f.exists())
		// System.out.println("File is found");

		Scanner scanner = new Scanner(f);

		// Set the delimiter used in file
		scanner.useDelimiter(",");
		// Get all tokens and store them in some data structure
		// I am just printing them

		while (scanner.hasNext()) {
			s[i] = scanner.next().toString();
//			System.out.print(s[i] + " ");
			i++;
		}
		return (s);
	}

}
