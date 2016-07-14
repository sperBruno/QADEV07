Feature: Create new story in project from pivotal tracker

  Background: create project
    Given I have the next parameters:
      | name   | projectTest |
      | public | true        |
    And I have the /projects endpoint
    And I send a POST request
    And stored as Project1
    And I login with credentials valid

  @project
  Scenario: Create new story
    Given I enter to projectTest
    And I create a new story
      | STORY_TITLE | storyTest |
    Then I expect that STORY_TITLE be equals to storyTest

