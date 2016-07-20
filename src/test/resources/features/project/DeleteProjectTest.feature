Feature: Testing for setting projects for Pivotal page

  Background: preconditions create project and login
    Given I send a POST request to /projects
      | name   | projectDelete |
      | public | true        |
    And stored as Project1
    And I login with credentials valid

  @project
  Scenario: Delete Project
    When I click [Project1.id] settings
    And I click delete the project1
    Then I expect the delete message: [Project1.name] was successfully deleted.