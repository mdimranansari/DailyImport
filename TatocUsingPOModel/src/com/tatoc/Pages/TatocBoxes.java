package com.tatoc.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TatocBoxes {
	
	public static void greenbox(FirefoxDriver fdriver)
	{
		if (fdriver.findElement(By.className("greenbox")).isDisplayed())
		  {
		   System.out.println("Pass1: Green box displayed");
		   fdriver.findElement(By.className("greenbox")).click();
		   }
	}
	
	public static void redbox(FirefoxDriver fdriver)
	{
		if (fdriver.findElement(By.className("redbox")).isDisplayed())
			fdriver.findElement(By.className("redbox")).click();
 
		String url = fdriver.getCurrentUrl();
	}
	
}
