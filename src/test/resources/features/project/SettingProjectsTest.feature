Feature: Testing for setting projects for Pivotal page

  Background: create project
    Given I send a POST request to /projects
      | name   | project Test |
      | public | true         |
    And stored as Project1
    And I login with valid credentials

  @project
  Scenario: Edit Project
    When I click [Project1.id] settings
    And I update general setting for Project1
      | description         | totally new |
      | START_ITERATIONS_ON | Saturday    |
      | ENABLE_TASKS        | true        |
      | ITERATION_LENGTH    | 4           |
      | PROJECT_START_DATE  | 7/23/2016   |
      | PROJECT_TIME_ZONE   | Arizona     |
#      | POINT_SCALE         | 0,1,2,3,5,8 |
    Then I expect a message say Changes saved.
    And Validate all setting projects