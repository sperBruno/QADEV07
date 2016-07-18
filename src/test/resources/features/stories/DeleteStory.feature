Feature: Delete a new story in a project from pivotal tracker

  Background: Create Project and story
    Given I send a POST request to /projects
      | name   | projectTest |
      | public | true        |
    And stored as Project1

    Given I send a POST request to /projects/[Project1.id]/stories
      | name        | storyTest       |
      | description | descriptionTest |
    And I login with credentials valid

  @story
  Scenario: Delete story
    Given I enter to projectTest
    When I delete the storyTest created
    Then I expect the message 1 story deleted