Feature: Login an application using UI Automation

  Scenario: Home page - Test for broken links

    Given Open the browser
    And pass url as "https://practicetestautomation.com/practice-test-login/"
    And Click on Home page
    Then Check for all broken links and list down all links if broken

  Scenario: Home page - Test if all links are working

    Given Open the browser
    And pass url as "https://practicetestautomation.com/practice-test-login/"
    And Click on Home page
    Then List down all links are visible in home page

  Scenario: Home page - Test if page content is visible and newsletter is working

    Given Open the browser
    And pass url as "https://practicetestautomation.com/practice-test-login/"
    And Click on Home page
    When Check current url if matches "https://practicetestautomation.com/"
    Then get the page description and store in text file "C:/Users/Hp/automationDemo/logs/"
    Then get newsletter title
    Then Put name as "sandip" in newsletter
    Then Put email as "sandip.datta@gmail.com" in newsletter
    And Click on button and check for the title "Get XPath cheat sheet"