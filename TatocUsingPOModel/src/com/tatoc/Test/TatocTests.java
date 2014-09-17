package com.tatoc.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.tatoc.Main.LaunchBrowser;
import com.tatoc.Pages.DungeonFrames;
import com.tatoc.Pages.ErrorPage;
import com.tatoc.Pages.TatocBoxes;

public class TatocTests {
	@Test	//Testcase to see if the greenbox is being clicked.
	public static void greenclick()
	{
		LaunchBrowser lb=new LaunchBrowser();
		FirefoxDriver fdriver = lb.browserlaunch();
		TatocBoxes tb=new TatocBoxes();
		tb.greenbox(fdriver);
		fdriver.close();
	}
	
	@Test		//Testcase to see if the redbox is being clicked.
	public static void redclick()
	{
		LaunchBrowser lb=new LaunchBrowser();
		FirefoxDriver fdriver = lb.browserlaunch();
		TatocBoxes tb=new TatocBoxes();
		tb.redbox(fdriver);
		String url= fdriver.getCurrentUrl();
		if(url.equals("http://172.16.1.17/tatoc/error"))
		{
			ErrorPage er=new ErrorPage();
			er.ErrorpageOnRedClick(fdriver, url);
		}
		fdriver.close();
	}
	
	@Test	//in case if the color is matching
	public static void colormatchTest()
	{
		LaunchBrowser lb=new LaunchBrowser();
		FirefoxDriver fdriver = lb.browserlaunch();
		TatocBoxes tb=new TatocBoxes();
		tb.greenbox(fdriver);
		DungeonFrames df=new DungeonFrames();
		FirefoxDriver driver=df.switchFirstFrame(fdriver);
		String clr1 = df.box1work(driver);
		FirefoxDriver driver2= df.switchSecondFrame(driver);
		String clr2 = df.box2work(driver2);
		fdriver = df.matching(clr1, clr2, fdriver);
		
	}
}
