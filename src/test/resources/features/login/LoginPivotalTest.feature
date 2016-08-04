@smoke
Feature: Testing for login Pivotal page

  Scenario: Login with valid credentials

    Given I login with valid credentials
    Then I expect the userName is displayed