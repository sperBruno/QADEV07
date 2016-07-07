Feature: Create Workspace Form

  Scenario: The "Create Workspace" button, returns a Create Workspace form

    Given I am on Pivotal Dashboard page
    When click on the Create Workspace button of the Dashboard
    Then I expect a Create Workspace form