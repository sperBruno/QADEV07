Feature: Testing for setting projects for Pivotal page

  Background: create project
    Given I send a POST request to /projects
      | name   | projectTest |
      | public | true        |
    And stored as Project1
    And I login with valid credentials

  @project
  Scenario: Delete Project
    When I click [Project1.id] settings
    And I Delete a project1
    Then I expect a message Delete say [Project1.name] was successfully deleted.