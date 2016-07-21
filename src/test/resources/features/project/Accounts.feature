Feature: Account

  Background: login

    Given I login with valid credentials


  @ProjectSelenium
  Scenario: Delete Account of a Project
    Given I create a new project
      | PROJECT_TITLE   | ProjectSeleniumTest |
      | PROJECT_ACCOUNT | luis                |
      | PROJECT_VISIBLE | true                |
    And I delete the account of the project
    Then I should receive a message of account deleted

