package org.test.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.test.api.WeatherApi;

public class WeatherApiSteps {

    @Given("the Hong Kong Observatory 9-day forecast API is available")
    public void theApiIsAvailable() {
        // This step assumes the API is accessible; no specific action needed
    }

    @When("I send a request to the API endpoint")
    public void iSendRequestToApiEndpoint() {
        WeatherApi.sendRequestToApi();
    }

    @Then("the response status code should be 200")
    public void responseStatusCodeShouldBe() {
        WeatherApi.verifyResponseStatus();
    }

    @And("I extract the relative humidity for the day after tomorrow")
    public void iExtractTheRelativeHumidityForTheDayAfterTomorrow() {
        //index 2 is the for the day after tomorrow
        WeatherApi.extractRelativeHumidity(2);
    }
}