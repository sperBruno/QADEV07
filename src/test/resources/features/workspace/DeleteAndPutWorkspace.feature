Feature: Delete and Put a Workspace

  Background: I have workspace created
    Given I send a POST request to /my/workspaces
      | name   | workspace3449 |
    And stored as Workspace11
    Given I login with credentials valid

  Scenario: Delete Workspace
    Given I click on [Workspace11.name] created
    When I click on Settings of SideBar
    And I click on Delete link and confirm
    Then I expect the next message: [Workspace11.name] was successfully deleted.

  @DeleteWorkspace
  Scenario: Edit Name Workspace

    Given I click on [Workspace11.name] created
    When I click on Settings of SideBar
    When I edit the name with: workspace2223
    And I click on Save button
    Then I expect the next message: Changes saved.