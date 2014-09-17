package com.maven.TestMaven1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TatocTest {

	WebDriver wdriver = new FirefoxDriver();

	@Given("^I visit Tatoc page$")
	public void I_visit_Tatoc_page() throws Throwable {
		// Express the Regexp above with the code you wish you had
		wdriver.manage().window().maximize();
		wdriver.get("http://172.16.1.17/tatoc/basic/grid/gate");
		wdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^I click on greenbox$")
	public void I_click_on_greenbox() throws Throwable {
		// Express the Regexp above with the code you wish you had
		this.wdriver.findElement(By.className("greenbox")).click();
	}

	@Then("^I reach color matching page$")
	public void I_reach_color_matching_page() throws Throwable {
		// Express the Regexp above with the code you wish you had
		String url = this.wdriver.getCurrentUrl();
		if(url.equalsIgnoreCase("http://172.16.1.17/tatoc/basic/frame/dungeon"))
			System.out.println("Greenbox is clicked and We are at second step");
	}
	
	/*@Given("^I visit tatoc app page$")
	public void I_visit_tatoc_app_page() throws Throwable {
		// Express the Regexp above with the code you wish you had
		//wdriver.manage().window().maximize();
		//wdriver.get("http://172.16.1.17/tatoc/basic/grid/gate");
		wdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		throw new PendingException();
	}

	@When("^I click on redbox$")
	public void I_click_on_redbox() throws Throwable {
		// Express the Regexp above with the code you wish you had
//		wdriver.get("http://172.16.1.17/tatoc/basic/grid/gate");
//		wdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Red box displayed");
		wdriver.findElement(By.className("redbox")).click();
		throw new PendingException();
	}

	@Then("^I reach Error page$")
	public void I_reach_Error_page() throws Throwable {
		// Express the Regexp above with the code you wish you had
		String url = wdriver.getCurrentUrl();
		if(url.equalsIgnoreCase("http://172.16.1.17/tatoc/error"))
			System.out.println("Redbox is clicked and We are at Error page");
		throw new PendingException();
	}*/

}
