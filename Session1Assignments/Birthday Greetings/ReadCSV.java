import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
/**
 * Program to read CSV file and send mail to the required receipants.
 * @author Mohammad Imran
 *
 */
public class ReadCSV {
	
	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		// TODO Auto-generated method stub
		
		String s[]= readingCSV();
		String s1[][]=new String[5][5];
		int slen=s.length;
		slen=slen/3;
		
		Date d1= new Date();

		@SuppressWarnings("deprecation")
		int dd = d1.getDate();
		@SuppressWarnings("deprecation")
		int mm= d1.getMonth();
		mm+=1;	// added 1 in month because it was not taking the current month as the current month.
		String today= dd+"/"+mm;

		int counter=0;

		for(int i=0;i<s.length;i++)
		{
			if(s[i].toString().equals(today))
			{
				counter = counter+1;
				System.out.println(counter);
				System.out.println(s[i]);
				int name_index=i+1;
				String b_nm=s[name_index];
				System.out.println(b_nm);
				int e_index=i+2;
				String e_id=s[e_index];
				System.out.println(e_id);

				// Recipient's email ID needs to be mentioned.
			      String to = e_id;

			      // Sender's email ID needs to be mentioned
			      String from = "mohammadimran@qainfotech.net";

			      // Assuming you are sending email from localhost
			         String host = "mail.qainfotech.net";

			      // Get system properties
			      Properties properties = System.getProperties();

			      // Setup mail server
			         properties.setProperty("mail.smtp.host", host);

			      // Get the default Session object.
			      Session session = Session.getDefaultInstance(properties);

			      try{
			         // Create a default MimeMessage object.
			         MimeMessage message = new MimeMessage(session);

			         // Set From: header field of the header.
			         message.setFrom(new InternetAddress(from));

			         // Set To: header field of the header.
			         message.addRecipient(Message.RecipientType.TO,
			                                  new InternetAddress(to));

			         // Set Subject: header field
			         message.setSubject("Happy Birthday!");

			         // Now set the actual message
			         message.setText("Dear "+b_nm+", Many many happy returns of the day!");

			         // Send message
			         Transport.send(message);
			         System.out.println("Sent message successfully....");
			      }catch (MessagingException mex) {
			         mex.printStackTrace();
			      }
			   }
			}
		}
	

		//Mathod to read CSV file data. File path should be modified before using this mathod on some other system.
	public static String[] readingCSV() throws FileNotFoundException
	{
		int i=0;
		String[] data = new String[50];
		String csvFile = "D:\\programming\\Daily practice\\birthdays.csv";
		File f=new File(csvFile);
		Scanner scanner = new Scanner(f);
		//Set the delimiter used in file
		scanner.useDelimiter(",");
		//Get all tokens and store them in some data structure
	    	//I am just printing them
		while (scanner.hasNext()) 
		    {
	        	data[i]=scanner.next().toString();
        		}
	        	i++;
	    }
	    return(data);
	}
}
