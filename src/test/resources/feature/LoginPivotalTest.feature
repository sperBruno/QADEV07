Feature: Testing for login Pivotal page

  Scenario: Login with valid credentials

    Given Load the home page pivotal
    When I click on the SigIn button
    And It show the login form
    When I type in the username input field
    And I click the next button
    When I type a password valid in input field
    And I click the login button
    Then It is expected that the display name equals WALTER_MERCADO_JALA