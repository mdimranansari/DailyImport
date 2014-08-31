
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
		
//		for (int i=0;i<s.length;i++)
//		{
//			System.out.println(i);
//			for(int k=0;k<3;k++)
//			{
//				s1[k][0]=s[i];
//				s1[k][1]=s[i+1];
//				s1[k][2]=s[i+2];
//				
//			}
//			//i=i+2;
//			System.out.print(s1[0][0]+" "+s1[1][0]+" "+s1[2][0]+" ");
//			
//		}
//		
//		System.out.print(s1[0][0]+" "+s1[1][0]+" "+s1[2][0]+" ");
//		System.out.print(s1[0][1]+" "+s1[1][1]+" "+s1[2][1]+" ");
//		System.out.print(s1[0][2]+" "+s1[1][2]+" "+s1[2][2]+" ");
//		
		
		
		
		Date d1= new Date();

		@SuppressWarnings("deprecation")
		int dd = d1.getDate();
		@SuppressWarnings("deprecation")
		int mm= d1.getMonth();
		mm+=1;	//done because it was not taking the current month as the current month.
		
//		@SuppressWarnings("deprecation")
//		int yy= d1.getYear();
		
		String today= dd+"/"+mm;
//		System.out.println(today);
//		System.out.println(s[0]);
//		System.out.println(s[3]);
//		System.out.println(s[6]);
//		
//		String s1= s[0];
		
		
//		if(s[0].equalsIgnoreCase(today))
//		{
//			System.out.println("match found");
//		}
//		FirefoxDriver fdriver=new FirefoxDriver();
//		fdriver.get("http://www.gmail.com");
//		fdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		fdriver.findElement(By.id("Email")).sendKeys("mdimran.0031@gmail.com");
//		fdriver.findElement(By.id("Passwd")).sendKeys("myInfosys@31");
//		fdriver.findElement(By.id("signIn")).click();
//		fdriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		
		
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
				
//				fdriver.findElement(By.xpath("//div[contains(text(),'COMPOSE')]")).click();
//				if(fdriver.findElement(By.name("to")) != null)
//				{
//					fdriver.findElement(By.name("to")).sendKeys(e_id);
//				}
//				else if(fdriver.findElement(By.xpath("//div[@contains(text(),'Recipients')]"))!=null)
//				{
//					fdriver.findElement(By.xpath("//div[@contains(text(),'Recipients')]")).click();
//					fdriver.findElement(By.xpath("//div[@contains(text(),'Recipients')]")).sendKeys(e_id);
//				}
//				
//				fdriver.findElement(By.name("subjectbox")).clear();
//				String sub="Happy Birthday";
//				fdriver.findElement(By.name("subjectbox")).sendKeys(sub);
//				String msg="Dear "+b_nm+", Many many happy returns of the day!";
//				fdriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);//.wait(10000);//
//				
//				fdriver.findElement(By.xpath("//div[@aria-label='Message Body']")).click();
//				fdriver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys(msg);
//				
//				fdriver.findElement(By.xpath("//div[@class='Ar Au']")).click();
//				fdriver.findElement(By.xpath("//div[@class='Ar Au']")).sendKeys(msg);
//				
//				fdriver.findElement(By.xpath("//body[@role='textbox']")).click();
//				fdriver.findElement(By.xpath("//body[@role='textbox']")).sendKeys(msg);
//				
//				
//
//				fdriver.findElement(By.xpath("//div[@aria-label='Send ‪(Ctrl-Enter)‬']")).click();
			}
		}
		
		
//		System.out.print(s[0]);//12/1/2014
//		System.out.print(s[1]);// Mohammad Imran
//		System.out.print(s[2]);	
//		System.out.print(s[3]);//12/1/2014
//		System.out.print(s[4]);// Mohammad Imran
//		System.out.print(s[5]);
//		System.out.print(s[6]);//12/1/2014
//		System.out.print(s[7]);// Mohammad Imran
//		System.out.print(s[8]);
	
      
public static String[] readingCSV() throws FileNotFoundException
{
	int i=0;
	String[] data = new String[50];
	String csvFile = "D:\\programming\\Daily practice\\birthdays.csv";
	File f=new File(csvFile);
//	if(f.exists())
//		System.out.println("File is found");
	Scanner scanner = new Scanner(f);
    //Set the delimiter used in file
    scanner.useDelimiter(",");
    //Get all tokens and store them in some data structure
    //I am just printing them
    while (scanner.hasNext()) 
    {
        //System.out.print(scanner.next());
  
        	//{
        	data[i]=scanner.next().toString();
        	//System.out.println(data[i]);
        //	}
        	i++;
    }
    return(data);
	}}
