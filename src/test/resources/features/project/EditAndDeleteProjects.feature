@acceptance
Feature: Testing for setting projects for Pivotal page

  Background: create project
    Given I send a POST request to /projects
      | name   | projectSettingProjects |
      | public | true                   |
    And I expect the status code 200
    And stored as Project1
    And I login with valid credentials

  @project
  Scenario: Delete Project
    When I click [Project1.id] settings
    And I click on delete project button
    Then I expect the delete message: [Project1.name] was successfully deleted.

  @project
  Scenario: Edit Project
    When I click [Project1.id] settings
    And I update general setting for Project1
      | description          | totally new |
      | START_ITERATIONS_ON  | Saturday    |
      | ENABLE_TASKS         | true        |
      | ITERATION_LENGTH     | 4           |
      | PROJECT_START_DATE   | 7/23/2016   |
      | PROJECT_TIME_ZONE    | Arizona     |
      | POINT_SCALE          | 0,1,2,3,5,8 |
      | VELOCITY_STRATEGY    | PastIters 4 |
      | ENABLE_RSS           | true        |
      | HIDE_EMAIL_ADDRESSES | true        |
      | BUGS_GIVEN_POINTS    | true        |
    Then I expect a message say Changes saved.
    And Validate all setting projects

  @project
  Scenario: Verified that start name day is equals start day
    When I click [Project1.id] settings
    And I update general setting for Project
      | description         | totally new |
      | START_ITERATIONS_ON | Saturday    |
      | ENABLE_TASKS        | true        |
      | ITERATION_LENGTH    | 4           |
      | PROJECT_START_DATE  | 7/24/2016   |
      | PROJECT_TIME_ZONE   | Arizona     |
    Then I click save button should be show a message say: [PROJECT_START_DATE.Value] is a [DATE_NAME.nameDay] and Iterations in this project start on [START_ITERATIONS_ON.value]
