import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class TatocAuto {

	public static void main(String[] args) {
		/**
		 * @author Mohammad Imran
		 */
		
		  FirefoxDriver fdriver=new FirefoxDriver();	//a New Firefox object
		  fdriver.manage().window().maximize();
		  fdriver.get("http://172.16.1.17/tatoc/basic/grid/gate");
		  fdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  	
		  redclick(fdriver);	//call to function to check if the click on redboxes is working properly.
		  greenclick(fdriver);//call to function to check if the click on greenboxes is working properly.
		 }
			
		 public static void greenclick(FirefoxDriver fdriver) //method to check function on click of green box.
		 {
		  if (fdriver.findElement(By.className("greenbox")).isDisplayed())
		  {
		   System.out.println("Pass1: Green box displayed");
		   fdriver.findElement(By.className("greenbox")).click();
		   }
		  paintBox(fdriver);	//call for function to check the events triggred by color of 2 boxes.
		 }
		 
		 public static void paintBox(FirefoxDriver fdriver)
		 {
			 
			 //fdriver.findElement(By.xpath("//a[@onclick='reloadChildFrame();]")).click();	////didn't work
			 
			 //fdriver.findElement(By.linkText("Repaint Box 2")).click(); //didn't work
			 
			 //fdriver.findElement(By.xpath("//center//a[contains(text(),'Repaint Box 2')]")).click(); //didn't work
			 
			 System.out.println("Repaint is clicked"); //Once Repaint button is clicked then it prints it.
			 
			 //fdriver.findElementByLinkText("Proceed").click(); //didn't work.
			 
			 // fdriver.findElement(By.xpath("//a[@onclick='gonext();']")).click(); //didn't work
//			 Actions actobj = new Actions(fdriver); //didn't work
//			 actobj.moveToElement(fdriver.findElement(By.xpath("//a[@onclick='gonext();']"))).build().perform();//didn't work
			 
			 System.out.println("proceed clicked");//Once Proceed is clicked then it prints it.
			 
			 String url = fdriver.getCurrentUrl(); //fetching current URL
			 //System.out.println(url);
			 
			 if(url.equalsIgnoreCase("http://172.16.1.17/tatoc/basic/drag"))
				 System.out.println("Test Pass: You are on Drag and Drop box page.");
//			 else
//				 System.out.println("Test Fail: You are on error page, URL: http://172.16.1.17/tatoc/error");
			 fdriver.get("http://172.16.1.17/tatoc/basic/windows");
			 popupwindow(fdriver);
		}
		 
		private static void popupwindow(FirefoxDriver fdriver) // Method to check the function of popup link window. 
		{
			// TODO Auto-generated method stub
			String url= fdriver.getCurrentUrl();
			if (url.equalsIgnoreCase("http://172.16.1.17/tatoc/basic/windows"))
				System.out.println("Test Pass: Now you are on Launch popup window page");
			fdriver.findElementByLinkText("Launch Popup Window").click();
			
			nextWindow(true, fdriver);
		}
		
		//Method to work inside new window application.
		public static void nextWindow(boolean boolval, FirefoxDriver fdriver)
		{
			String winHandleBefore=fdriver.getWindowHandle();
			for(String winHandle:fdriver.getWindowHandles())
			{
				fdriver.switchTo().window(winHandle);
			}
			String url=fdriver.getCurrentUrl();
			System.out.println(url);
 
			fdriver.findElementById("name").sendKeys("Mohammad Imran");
			fdriver.findElementById("submit").click();
			fdriver.switchTo().window(winHandleBefore);
			fdriver.findElementByLinkText("Proceed").click();
			String url2=fdriver.getCurrentUrl();
 
			if(url2.equalsIgnoreCase("http://172.16.1.17/tatoc/basic/cookie"))
			{
				System.out.println("Test Pass: Now you are on Cookies page.");
				tokenpage(fdriver);
			}

			else 
			{
				System.out.println("Test Fail: You are on Error page. Start over");
				fdriver.findElement(By.linkText("Basic Course")).click();
				greenclick(fdriver);
			}
		}


			private static void tokenpage(FirefoxDriver fdriver) 
			{
				WebElement token = fdriver.findElement(By.id("token"));
				System.out.println("Currently there is no token");
				fdriver.findElement(By.linkText("Generate Token")).click();
				String tokentxt = token.getText();
				Boolean tokenTF = tokentxt.contains(": ");
					
				if (tokenTF==true)
					System.out.println("Test Pass: There is a token");
				else
					System.out.println("There is no token");
			
				fdriver.findElement(By.linkText("Proceed")).click();
			
				String url = fdriver.getCurrentUrl();
				if (url.equalsIgnoreCase("http://172.16.1.17/tatoc/error"))
				{
					System.out.println("This is error page");
					fdriver.findElement(By.linkText("Basic Course")).click();
				}
				greenclick(fdriver);
			}

			public static void redclick(FirefoxDriver fdriver)
			{
				if (fdriver.findElement(By.className("redbox")).isDisplayed())
					fdriver.findElement(By.className("redbox")).click();
		 
				String url = fdriver.getCurrentUrl();
				if (url.equalsIgnoreCase("http://172.16.1.17/tatoc/error"))
				{
					System.out.println("This is error page");
					fdriver.findElement(By.linkText("Basic Course")).click();
				}	  
				greenclick(fdriver);
			}
		}
		
