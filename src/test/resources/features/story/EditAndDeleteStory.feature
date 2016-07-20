Feature: Delete a new story in a project from pivotal tracker

  Background: Create Project and story
    Given I send a POST request to /projects
      | name   | projectTest |
      | public | true        |
    And stored as Project1
    And I send a POST request to /projects/[Project1.id]/stories
      | name | storyTest |
    Then I login with valid credentials

  @story
  Scenario: Delete story
    Given I enter to [Project1.name]
    When I delete the story created
    Then I expect the message 1 story deleted

  @story
  Scenario: Edit story
    Given I enter to [Project1.name]
    When I edit the next parameter
      | STORY_TITLE | storyTestSet       |
      | DESCRIPTION | descriptionTestSet |
      | LABELS      | labeltestset       |
      | COMMENT     | commentTestSet     |
    Then I validate fields