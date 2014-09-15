import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TranslateUSel {
	@Test
	public static void usesel() throws FileNotFoundException,
			InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"drivers//chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		String lang = "Italian";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.bing.com/translator/");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		ReadCSV rd = new ReadCSV();
		
		//To read data from csv file.
		String[] data = rd.readCSV();

		//to keep the to be translated text, the language to be translated from and to be translated to.
		String text, from, to, translated;
		int i = 0;

		while (data[i] != null) {
			text = data[i];
			from = data[i + 1];
			to = data[i + 2];
			i += 3;
			driver.findElement(By.id("InputText")).sendKeys(text);
//			driver.findElement(By.id("HeaderTitle_SrcLangList")).sendKeys(from);
			// opening the table and selecting the language to translate to.
			
			driver.findElement(By.id("Header_DstLangList")).sendKeys(to);
			//Clicking on Translation button
			driver.findElement(By.id("TranslateButtonText")).click();
			
			System.out.println("Translation of "+text+" in "+to+" is "+driver.findElement(By.id("OutputText")).getText().toString());
			driver.findElement(By.id("InputText")).clear();
//			driver.findElement(By.id("OutputText")).clear();
		}

	}
}
