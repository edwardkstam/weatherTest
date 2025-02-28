package org.test.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.test.pages.ForecastPage;
import org.test.pages.HomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ForecastStep extends ForecastPage  {
    ForecastPage forecastPage;

    public ForecastStep() {
        this.forecastPage = new ForecastPage(); // Initialize the field
    }

    @Then("I should be on the forecast screen")
    public void i_should_be_on_the_forecast_screen() {
        assertTrue(forecastPage.isForecastScreenDisplayed());
    }

    @Then("I should see the 9-day forecast title")
    public void i_should_see_the_nine_day_forecast_title() {
        assertTrue(forecastPage.isNineDayForecastDisplayed());
    }

    @Then("I should see the 9-day forecast is selected")
    public void i_should_see_the_nine_day_forecast_selected() {
        assertTrue(forecastPage.isNineDayForecastSelected());
    }


}
