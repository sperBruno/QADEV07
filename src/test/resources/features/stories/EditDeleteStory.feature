Feature: Edit and delete a new story in a project from pivotal tracker

  Background: create story
    Given I send a POST request to /projects
      | name   | projectTest |
      | public | true        |
    And stored as [Project1]
    And I send a POST request to /projects/[Project1.id]/stories
      | name | storyTest |
    And I login with credentials valid

  @projectStory
  Scenario: Edit story
    Given I enter to projectTest
    When I edit the next parameter
      | STORY_TITLE | storyTestSet       |
      | DESCRIPTION | descriptionTestSet |
      | LABELS      | labelTestSet       |
      | TASKS       | taskTestSet        |
      | COMMENT     | commentTestSet     |
    Then I validate fields

  @projectStory
  Scenario: Delete story
    Given I enter to projectTest
    When I delete the storyTest created
    Then I expect the message 1 story deleted

