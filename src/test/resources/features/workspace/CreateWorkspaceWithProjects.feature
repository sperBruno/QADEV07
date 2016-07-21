@CleanEnviroment
Feature: Workspace with Projects

  Background: I have projects created
    Given I send a POST request to /projects
      | name   | ProjectTest3 |
      | public | true |
    And stored as ProjectW
    Given I login with valid credentials


  @project
  Scenario: Add project to Workspace created

    Given I create a new Workspace
      | WORKSPACE_NAME | WorkspaceTest3 |
    And click on the Create Workspace button
    When I click on Add Projects button
    And I select the project created previously
    And I click on Save Workspace button
    Then I expect a workspace with the [ProjectW.name] project name