Feature: Create new story in project from pivotal tracker

  Background: create project
    Given I send a POST request to /projects
      | name   | projectTest |
      | public | true        |
    And stored as Project1
    And I login with credentials valid

  @stories
  Scenario: Create new story
    Given I enter to projectTest
    And I create a new story
      | STORY_TITLE | storyTest       |
      | DESCRIPTION | descriptionTest |
      | LABELS      | labeltest       |
      | COMMENT     | commentTest     |
    Then I validate fields
