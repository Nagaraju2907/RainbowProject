Feature: Login page of Salesforce

  @SC01  @regression

    #before
  Scenario: Error message validation with invalid credi
    #beforestep
   # Given user navigates to salesfroce application
  #afterStep
  #beforestep
    When user enter the username "learnmore" and password "123"
  #afterStep
     #beforestep
    And user clicks the login button
    #afterStep
     #beforestep
    Then user validate the error message
    #after

    #before
    @multiple
  Scenario Outline: mutiple test
    Given user navigates to salesfroce application
    When user enter the username "<user name>" and password "<password>"
    And user clicks the login button
    Then user validate the error message
   Examples:
     | user name | password |
     | aravinth  | 1223     |
     | jerry     | abc      |
#after

  #before
  @SC02  @regression
  Scenario: Login validation with valid credi
    Given user navigates to salesfroce application
    When user enter the username "apple" and password "abc"
    And user clicks the login button
    Then verify whether the user navigates to Homepage

   #after