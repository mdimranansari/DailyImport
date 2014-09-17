package com.tatoc.Main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchBrowser {

	public static FirefoxDriver browserlaunch()
	{
		  FirefoxDriver fdriver=new FirefoxDriver();	//a New Firefox object
		  fdriver.manage().window().maximize();
		  fdriver.get("http://172.16.1.17/tatoc/basic/grid/gate");
		  fdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  return fdriver;
	}
}
