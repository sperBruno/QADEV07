Feature: Workspace

  Background: I login into pivotal
    Given I login with valid credentials
    When I am on Pivotal Dashboard page

  Scenario: The "Create Workspace" button, returns a Create Workspace form

    Given click on the Create Workspace button of the Dashboard
    Then I expect a Create Workspace form

  @DeleteWorkspace
  Scenario: Create a Workspace with a name valid

    Given I am on Pivotal Create Workspace form
    When I fill with My Workspace253 the name Workspace field
    And click on the Create Workspace button of the Form
    Then the display name equals to My Workspace253