Feature: Create new story in project from pivotal tracker

  Background: create project
    Given I send a POST request to /projects
      | name   | projectTest |
      | public | true        |
    And stored as Project1
    And I login with valid credentials

  @stories
  Scenario: Create new story
    Given I enter to [Project1.name]
    When I create a new story
      | STORY_TITLE | storyTest       |
      | STORY_TYPE  | Bug             |
      | DESCRIPTION | descriptionTest |
      | LABELS      | labeltest       |
      | COMMENT     | commentTest     |
    Then I validate fields

  @stories
  Scenario: Create story without title
    Given I enter to [Project1.name]
    When I create a new story without title
    Then I expect the alert Please enter a story title.
    
  @stories
  Scenario: Cancel create story with parameters
    Given I enter to [Project1.name]
    When I fill parameters to new story
      | STORY_TITLE | storyTest       |
      | STORY_TYPE  | Bug             |
      | DESCRIPTION | descriptionTest |
      | LABELS      | labeltest       |
      | COMMENT     | commentTest     |
    Then I expect none story added