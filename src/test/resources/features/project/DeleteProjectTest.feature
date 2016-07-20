Feature: Testing for setting projects for Pivotal page

  Background: Preconditions create project and login
    Given I send a POST request to /projects
      | name   | projectTest |
      | public | true        |
    And stored as Project1
    And I login with valid credentials

  @project
  Scenario: Delete Project
    When I click [Project1.id] settings
    And I click on delete project button
    Then I expect the delete message: [Project1.name] was successfully deleted.