package com.maven.TestMaven1;
import org.junit.runner.RunWith;

import cucumber.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(format={"pretty","html:target/cucumber"},
  features="src/test/Test.feature")

public class TatocFeaturemap {
	
}
