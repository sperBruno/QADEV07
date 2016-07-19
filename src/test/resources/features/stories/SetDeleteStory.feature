Feature: Delete a new story in a project from pivotal tracker

  Background: Create Project and story
    Given I send a POST request to /projects
      | name   | projectTest |
      | public | true        |
    And stored as Project1
    And I send a POST request to /projects/[Project1.id]/stories
      | name        | storyTest       |
    Then I login with credentials valid

  @story
  Scenario: Edit story
    Given I enter to projectTest
    When I edit the next parameter
      | STORY_TITLE | storyTestSet       |
      | DESCRIPTION | descriptionTestSet |
    Then I validate fields

  @story
  Scenario: Delete story
    Given I enter to projectTest
    When I delete the storyTest created
    Then I expect the message 1 story deleted