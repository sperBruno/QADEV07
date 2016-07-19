Feature: Testing for login Pivotal page

  Scenario: Login with valid credentials

    Given I login with valid credentials
    Then  It is expected that the display userName