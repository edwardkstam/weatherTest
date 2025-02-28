package org.test.steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.test.TestRunner;
import org.test.pages.ForecastPage;
import org.test.pages.HomePage;


import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;
import static org.testng.Assert.assertTrue;

public class HomeStep extends HomePage{
    HomePage homePage;

    public HomeStep() {
        this.homePage = new HomePage(); // Initialize the field
    }

    @Given("I test if Notification view found")
    public void iTestIfNotificationViewFound() {

        TestRunner.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        try {
            TestRunner.getDriver().navigate().back();
        } catch (Exception e) {
            //Exception
        }
    }

    @When("I am on the home screen")
    public void iAmOnTheHomeScreen() {
        assertTrue(homePage.isHomeScreenDisplayed());
    }

    @Given("I click navigate up button")
    public void iClickNavigateUpButton() {
        homePage.clickNavigateUp();
    }

    @Then("I click Forecast & Warning Services")
    public void iClickForecastAndWarningDropDownList() {
        homePage.clickForecastAndWarning();
    }

    @Then("I select 9-Day Forecast")
    public void iSelectNineDayForecast() {
        homePage.selectNineDayForecast();
    }

}
