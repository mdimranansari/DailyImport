package com.tatoc.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ErrorPage {
	
	public static FirefoxDriver ErrorpageOnRedClick(FirefoxDriver fdriver,String url)
	{
		if (url.equalsIgnoreCase("http://172.16.1.17/tatoc/error"))
		{
			System.out.println("This is error page, now start over from First page.");
			fdriver.findElement(By.linkText("Basic Course")).click();
		}
		return fdriver;
	}
	
	public static FirefoxDriver Errorpage(FirefoxDriver fdriver,String url)
	{
		if (url.equalsIgnoreCase("http://172.16.1.17/tatoc/error"))
		{
			System.out.println("This is error page");
			fdriver.findElement(By.linkText("Basic Course")).click();
		}
		return fdriver;
	}
		  
}
