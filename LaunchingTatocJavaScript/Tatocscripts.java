package LaunchingTatocJavaScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import Launching.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.lang.System;

public class Tatocscripts {
	JavascriptExecutor js;
	WebDriverWait wait;
	ChromeDriver driver;

	@BeforeClass
	public void Beforeall() {
		System.setProperty("webdriver.chrome.driver",
				"D:/programming and qa works/TatocJavaScript/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://172.16.1.17/tatoc/basic/grid/gate");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;

	}

	@Test
	public void green() {
		js.executeScript("document.getElementsByClassName('greenbox')[0].click()"); //Clicking on Green box.
		
		//Finding all the elements and saving their addresses in string.
		String frame1 = "return document.getElementById('main').contentWindow.document.getElementById('answer').className";
		String frame2 = "return document.getElementById('main').contentWindow.document.getElementById('child').contentWindow.document.getElementById('answer').className";
		String page = "return document.getElementsByClassName('page')";
		String paintbtn = "return document.getElementById('main').contentWindow.document.getElementsByName('Repaint Box2')";
		
		String clr1 = (String) js.executeScript(frame1); // finding color of first box.
		System.out.println(clr1);
		String clr2 = (String) js.executeScript(frame2); // finding color of first box.
		System.out.println(clr2);
		js.executeScript(paintbtn); // finding color of first box.
		clr2 = (String) js.executeScript(frame2); // finding color of first box.
		System.out.println(clr2);
		
//		js.executeScript(page);	//Returning to the main page.
//		String clr2 = (String) js.executeScript(frame2); //finding color of second box
//		System.out.println(js.executeScript(clr1));
//		js.executeScript(page);	//returning to the main page
//		js.executeScript(paintbtn);	//clicking paint button
//		
//		System.out.println(js.executeScript(clr1));	//printing the color of first box
//		System.out.println(js.executeScript(clr2)); //printing the color of secong box
		
		//driver.switchTo().frame("document.getElementById('main')");
//		js.executeScript(arg0, arg1)
//		String b1= "document.getElementsByClassName('greenbox')[0]";
//		WebElement wb1=//(WebElement)b1;
//		Object clrbox1 = js.executeScript(b1).getClass();
//		String box1clr=clrbox1.toString();
//		System.out.println(box1clr);
		
	}
	
	//@Test
	public void red() {
		js.executeScript("document.getElementsByClassName('redbox')[0].click()");
	}
}
