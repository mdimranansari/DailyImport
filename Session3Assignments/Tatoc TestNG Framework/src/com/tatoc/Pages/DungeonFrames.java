package com.tatoc.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DungeonFrames {
	
	//method to switch to first frame
	public static FirefoxDriver switchFirstFrame(FirefoxDriver fdriver)
	{
		WebElement frame1= fdriver.findElement(By.id("main"));
		fdriver.switchTo().frame(frame1);
		System.out.println("Switched to outer frame");
		return fdriver;
	}
	
	//method to switch to child frame
	public static FirefoxDriver switchSecondFrame(FirefoxDriver fdriver)
	{
		WebElement frame2= fdriver.findElement(By.id("child"));
		fdriver.switchTo().frame(frame2);
		System.out.println("Switched to Inner frame");
		return fdriver;
	}
	
	//method to find box1 and getting its color.
	public static String box1work(FirefoxDriver fdriver)
	{
		WebElement box = fdriver.findElement(By.id("answer"));
		
	    String clr=box.getAttribute("class");
	    System.out.println(clr);
	    return clr;
	}

	//method to find box2 in child frame and getting its color.
	public static String box2work(FirefoxDriver fdriver)
	{
	    WebElement box2 = fdriver.findElement(By.id("answer"));
	    String clr=box2.getAttribute("class");
	    System.out.println(clr);
	    return clr;
	}
	
	//method for the case when the colors in box1 and box2 are matching by multiple clicks.
	public static FirefoxDriver matching(String clr1, String clr2, FirefoxDriver fdriver)
	{
		fdriver.switchTo().defaultContent();
		while(clr1!=clr2)
		{
			FirefoxDriver driver=DungeonFrames.switchFirstFrame(fdriver);
			clr1 = DungeonFrames.box1work(driver);
			driver.findElement(By.linkText("Repaint Box 2")).click();
			FirefoxDriver driver2= DungeonFrames.switchSecondFrame(driver);
			clr2 = DungeonFrames.box2work(driver2);
		}
		System.out.println("ColorMatch, clicking to Proceed");
		DungeonFrames.switchFirstFrame(fdriver).findElementByLinkText("Proceed").click();
		return fdriver;
	}
	
}

