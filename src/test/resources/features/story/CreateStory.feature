Feature: Create new story in project from pivotal tracker

  Background: create project
    Given I send a POST request to /projects
      | name   | projectTest |
      | public | true        |
    And I expect the status code 200
    And stored as Project1
    And I login with valid credentials

  @project
  Scenario: Create new story
    Given I enter to [Project1.name]
    When I create a new story
      | STORY_TITLE | storyTest       |
      | STORY_TYPE  | bug             |
      | DESCRIPTION | descriptionTest |
      | LABELS      | labeltest       |
      | COMMENT     | commentTest     |
    Then I validate fields

  @project
  Scenario: Create story without title
    Given I enter to [Project1.name]
    When I create a new story without title
    Then I expect the alert Please enter a story title.
    
  @project
  Scenario: Cancel create story with parameters
    Given I enter to [Project1.name]
    When I fill parameters to new story
      | STORY_TITLE | storyTest       |
      | STORY_TYPE  | Bug             |
      | DESCRIPTION | descriptionTest |
      | LABELS      | labeltest       |
      | COMMENT     | commentTest     |
    Then I expect none story added