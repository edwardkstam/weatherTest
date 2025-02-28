Feature: Task 1 MyObservatory App

  @Test
  Scenario: Verify navigation to 9-day forecast
    When I am on the home screen
    When I click navigate up button
    And I click Forecast & Warning Services
    And I select 9-Day Forecast
    Then I should be on the forecast screen
    And I should see the 9-day forecast title
    And I should see the 9-day forecast is selected