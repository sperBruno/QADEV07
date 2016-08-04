Feature: Account

  Background: login

    Given I login with valid credentials

  Scenario: Delete Account of a Project
    Given I create a new project
      | PROJECT_TITLE   | ProjectSeleniumTest |
      | PROJECT_ACCOUNT | luis                |
      | PROJECT_VISIBLE | true                |
    And I delete the account of the project
    Then I should receive a message of account deleted from a project

  Scenario: Create Account
    Given I get into account Page
    And I create a new account with name Jorge
    Then I should get into Jorge Account setting
    Then I delete Jorge account
    Then I should receive a message of account deleted