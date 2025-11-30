Feature: Test GUI Elements
  Scenario: : Test GUI Elements
    Given Open the browser
    And Run url as "https://testautomationpractice.blogspot.com/"
    And Click on Home page
    When Check current url if matches "https://testautomationpractice.blogspot.com/"
    And Check for the title "Automation Testing Practice"
    Then Fill the form when pass string as "Sandip" where "id" is "name"
    And Fill the form when pass string as "sandipdattanit@gmail" where "id" is "email"
    And Fill the form when pass string as "8910508689" where "id" is "phone"
    And Fill the form when pass string as "Kolkata, west bengal" where "id" is "textarea"
    And Choose radio button where "id" is "male"
    And Choose check-box where "id" is "sunday"
    And Select string as "India" where "id" is "country"
    And Select string as "Red" where "id" is "colors"
    And Select string as "Cheetah" where "id" is "animals"
    And Click on Submit button where "classname" is "submit-btn"
    Then Close the browser