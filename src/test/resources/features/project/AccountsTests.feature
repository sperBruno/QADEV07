Feature: Account

  Background: login

    Given I login with credentials valid
    And I create a new project
      | PROJECT_TITLE       | ProjectSeleniumTest |
      | PROJECT_ACCOUNT     | luis                |
      | PROJECT_SAMPLE_DATA | true                |

 
  Scenario: Delete Account of a Project
    Given I delete the account of the project
    Then I should receive a message of account deleted

