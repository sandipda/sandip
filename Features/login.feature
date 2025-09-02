Feature: Login an application using UI Automation

  Scenario: Login page test - Positive LogIn test

    Given Open the browser
    And pass url as "https://practicetestautomation.com/practice-test-login/"
    When Check current url
    And Get page title if matches "Test login"
    Then get the page description
    Then pass username "student"
    And pass password "Password123"
    And check if button is clickable or not and get button text
    When Click on Submit button

  Scenario: Login page test - Negative username test

    Given Open the browser
    And pass url as "https://practicetestautomation.com/practice-test-login/"
    When Check current url
    Then Get page title if matches "Test login"
    Then get the page description
    Then pass username "incorrectUser"
    And pass password "Password123"
    And check if button is clickable or not and get button text
    When Click on Submit button
    And Check if error displayed
    And Verify if error message text matches "Your username is invalid!"

  Scenario: Login page test - Negative password test

    Given Open the browser
    And pass url as "https://practicetestautomation.com/practice-test-login/"
    When Check current url
    Then Get page title if matches "Test login"
    Then get the page description
    Then pass username "student"
    And pass password "incorrectPassword"
    And check if button is clickable or not and get button text
    When Click on Submit button
    And Check if error displayed
    And Verify if error message text matches "Your password is invalid!"