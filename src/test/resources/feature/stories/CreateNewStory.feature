Feature: Create new story in project from pivotal tracker

  Background: Create Project
    Given I login with valid credentials
    When I have the /projects endpoint
    And I send a POST request
      | name   | projectTest |
      | public | true        |
    And stored as Project1

  Scenario: Create new story
    Given I stay in the main page of project
    Then I press on newStory button
    And I fill the story name text with
    |name|newStory|
    Then I expect that name be equals to newStory

