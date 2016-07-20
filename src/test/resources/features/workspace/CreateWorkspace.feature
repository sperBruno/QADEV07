Feature: Workspace

  Background: I login into pivotal
    Given I login with valid credentials

  @DeleteWorkspace
  Scenario: Create a Workspace with a name valid

    Given I create a new Workspace
      | WORKSPACE_NAME | My Workspace253 |
    And click on the Create Workspace button
    Then the display name equals to My Workspace253

  Scenario: Create a Workspace with empty name

    Given I create a new Workspace
      | WORKSPACE_NAME |    |
    And click on the Create Workspace button
    Then A message displayed: workspace name can't be blank