@CleanEnviroment
Feature: Delete and Put a Workspace

  Background: I have workspace created
    Given I send a POST request to /my/workspaces
      | name   | WorkspaceTest4 |
    And stored as Workspace11
    Given I login with valid credentials

  Scenario: Delete Workspace

    Given I click on [Workspace11.name] created
    When I click on Settings of SideBar
    And I click on Delete link and confirm
    Then I expect the next message: [Workspace11.name] was successfully deleted.

  @DeleteWorkspace
  Scenario: Edit Name Workspace

    Given I click on [Workspace11.name] created
    When I click on Settings of SideBar
    When I edit the name with: WorkspaceTest5
    And I click on Save button
    Then I expect the next message: Changes saved.