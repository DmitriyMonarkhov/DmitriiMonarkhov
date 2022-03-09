package com.epam.tc.hw5.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {
    "src/test/resources/cucumber/exercise1.feature",
    "src/test/resources/cucumber/exercise2.feature",
    "src/test/resources/cucumber/exercise3.feature"})
public class RunAcceptanceTest extends AbstractTestNGCucumberTests {
}
