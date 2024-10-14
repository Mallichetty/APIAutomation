Feature: Validate the new booking feature's get and post api

  @Regression
  Scenario: Verify if user can complete the new booking
    When user hits the booking post api to get the expected response code as "200"
    Then user hits the booking get api to confirm on the new booking with the expected response code as "200"