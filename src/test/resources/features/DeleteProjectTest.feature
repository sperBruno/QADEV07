Feature: Testing for setting projects for Pivotal page

  Background: create project
    Given I have the next parameters:
      | name   | project to create delete |
      | public | true                     |
    And I have the /projects endpoint
    And I sent a POST request
    And stored as Project1
    And I login with credentials valid

  @project
  Scenario: Delete Project
    When I click Project1.name settings
    And I Delete a project1
    Then I expect a message Delete say project1.name was successfully deleted.