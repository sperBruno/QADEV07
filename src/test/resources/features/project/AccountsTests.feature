Feature: Account

  Background: login

    Given I login with valid credentials
#    And I create a new project
#      | PROJECT_TITLE       | ProjectSeleniumTest |
#      | PROJECT_ACCOUNT     | luis                |
#      | PROJECT_SAMPLE_DATA | true                |
#
#  @ProjectSelenium
#  Scenario: Delete Account of a Project
#    Given I delete the account of the project
#    Then I should receive a message of account deleted

  Scenario: create an account
  Given I get into account Page
    And I create an account with name felipe

