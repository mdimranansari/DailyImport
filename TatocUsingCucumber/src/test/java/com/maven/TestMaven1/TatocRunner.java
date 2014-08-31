package com.maven.TestMaven1;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@Cucumber.Options(format={"pretty","html:target/cucumber"},
features="src/test/Test.feature")

public class TatocRunner {}
