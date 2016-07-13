Feature: Testing for setting projects for Pivotal page

  Background: create project
    Given I have the next parameters:
      | name   | project to create stories |
      | public | true                      |
    And I have the /projects endpoint
    And I sent a POST request
    And stored as Projects1
    And I login with credentials valid
  @project
  Scenario: Edit Project
    When I click Project1.name settings
    And I update general setting for Project1
      | description | totally new |
      | PROJECT_START_DATE | Sunday |
      | ENABLE_TASKS | false |

    Then I expect a message say Changes saved.
    And The description projects should be equals totally new