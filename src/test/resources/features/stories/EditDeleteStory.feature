Feature: Edit and delete a new story in a project from pivotal tracker

  Background: create story
    Given I have the next parameters:
      | name   | projectTest |
      | public | true        |
    And I have the /projects endpoint
    And I send a POST request
    And stored as Project1
    And I have the next parameters:
      | name   | storyTest |
    And I have the /projects/[Project1.id]/stories/ endpoint
    And I send a POST request
    And I login with credentials valid

  @project
  Scenario: Delete story
    Given I enter to projectTest
    When I delete the storyTest created
    Then I expect the message 1 story deleted

  @project
  Scenario: Edit story
    Given I enter to projectTest
    When I edit the next parameter
      | STORY_TITLE   | storyTestSet |
    Then I verify fields