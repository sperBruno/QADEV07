@acceptance
Feature: Delete a new story in a project from pivotal tracker

  Background: Create Project and story
    Given I send a POST request to /projects
      | name   | projectTest |
      | public | true        |
    And stored as Project1
    And I send a POST request to /projects/[Project1.id]/stories
      | name | storyTest |
    And stored as Story1
    Then I login with valid credentials

  @story @dashboard
  Scenario: Edit story
    Given I enter to [Project1.name]
    When I edit the next parameter
      | STORY_TITLE | story       |
      | STORY_TYPE  | release     |
      | DESCRIPTION | description |
      | LABELS      | label       |
      | COMMENT     | comment     |
    Then I validate fields

  @story @dashboard
  Scenario: Delete story
    Given I enter to [Project1.name]
    When I delete the story created
    Then I expect the message 1 story deleted

  @story @dashboard
  Scenario: Cancel delete story
    Given I enter to [Project1.name]
    When I cancel delete the story created
    Then I expect the [Story1.name] is show

