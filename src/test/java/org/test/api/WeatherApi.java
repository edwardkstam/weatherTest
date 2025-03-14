package org.test.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class WeatherApi {
    private static final String API_ENDPOINT = "https://data.weather.gov.hk/weatherAPI/opendata/weather.php";
    private static Response response;
    private static String humidityRange;
    private static String forecastDate;

    public static void sendRequestToApi() {
        response = RestAssured
            .given()
                .queryParam("dataType", "fnd")
                .queryParam("lang", "en")
            .when()
                .get(API_ENDPOINT)
            .then()
                .extract().response();
    }

    public static void verifyResponseStatus() {
        int statusCode = response.getStatusCode();
        System.out.println("API response status code: " + statusCode);
        Assert.assertEquals(statusCode, 200, "API request failed with status code: " + statusCode);
    }

    public static void extractRelativeHumidity(int dayAfterTomorrowIndex) {

        // Extract min and max relative humidity
        int minRh = response.jsonPath().getInt("weatherForecast[" + dayAfterTomorrowIndex + "].forecastMinrh.value");
        int maxRh = response.jsonPath().getInt("weatherForecast[" + dayAfterTomorrowIndex + "].forecastMaxrh.value");
        humidityRange = minRh + "-" + maxRh + "%";

        // Extract and format the forecast date for verification
        String forecastDateRaw = response.jsonPath().getString("weatherForecast[" + dayAfterTomorrowIndex + "].forecastDate");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate parsedDate = LocalDate.parse(forecastDateRaw, formatter);
        forecastDate = parsedDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        // Output the result
        System.out.println("Relative humidity for " + forecastDate + " (day after tomorrow): " + humidityRange);


    }
}
