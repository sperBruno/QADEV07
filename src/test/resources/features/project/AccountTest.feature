Feature: Account
Background: login

  Given I login with credentials valid


  Scenario: Delete Account
    Given I get into account Page
    And I delete the account of the project
    Then I should receive a message of account deleted
