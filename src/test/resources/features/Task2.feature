Feature: Task 2 Hong Kong Observatory API


  @Test
  Scenario: Test the request response status is whether successful or not
    Given the Hong Kong Observatory 9-day forecast API is available
    When I send a request to the API endpoint
    Then the response status code should be 200

  @Test
  Scenario: Extract relative humidity for the day after tomorrow from the API response
    Given the Hong Kong Observatory 9-day forecast API is available
    When I send a request to the API endpoint
    And I extract the relative humidity for the day after tomorrow