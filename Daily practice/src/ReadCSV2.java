import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ReadCSV2 {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
String[][] data=readingCSV();
	}

	public static String[][] readingCSV() throws FileNotFoundException
	{
		int i=0,j=0;
		String[][] data = new String[3][3];
		String csvFile = "D:\\programming\\Daily practice\\birthdays.csv";
		File f=new File(csvFile);
//		if(f.exists())
//			System.out.println("File is found");
		Scanner scanner = new Scanner(f);
	    //Set the delimiter used in file
	    scanner.useDelimiter(",");
	    //Get all tokens and store them in some data structure
	    //I am just printing them
	    while (scanner.hasNext()) 
	    {
	        //System.out.print(scanner.next());
	  
	        	
				//{
	        	data[i][j]=scanner.next().toString();
	        	//System.out.println(data[i]);
	        //	}
	        	j++;
	        	i+=2;
	    }
	    
	    return(data);
		}}


