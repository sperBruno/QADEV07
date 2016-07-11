Feature: Testing for setting projects for Pivotal page

  Background: create project
    Given I have the next parameters:
      | name   | project to create stories |
      | public | true                      |
    And I have the /projects endpoint
    And I sent a POST request
    And I login with credentials valid

  Scenario: Edit Project
    When I click Project1.name settings
    And I update general setting for Project1
      | description | totally new |
      | description | totally new |
      | description | totally new |
      | description | totally new |
    Then I expect a message say change saved
    And The description projects should be equals totally new