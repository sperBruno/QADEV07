Feature: Testing for setting projects for Pivotal page

  Background: create project
    Given I send a POST request to /projects
      | name   | projectTest |
      | public | true        |
    And stored as Project1
    And I login with credentials valid

  @project
  Scenario: Edit Project
    When I click Project1.id settings
    And I update general setting for Project1
      | description        | totally new |
      | PROJECT_START_DATE | Saturday    |
      | ENABLE_TASKS       | true        |
      | ITERATION_LENGTH   | 4           |
    Then I expect a message say Changes saved.
    And Validate all setting projects