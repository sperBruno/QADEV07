Feature: Edit a new story in a project from pivotal tracker

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
  Scenario: Edit story
    Given I enter to projectTest
    When I edit the next parameter
      | STORY_TITLE | storyTestSet       |
      | DESCRIPTION | descriptionTestSet |
    Then I validate fields


