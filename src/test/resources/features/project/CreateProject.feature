Feature: Create Project

  Background: I login into pivotal
    Given I login with valid credentials

  @ProjectSelenium
  Scenario: Create Project
    Given I create a new project
      | PROJECT_TITLE       | ProjectSeleniumTest |
      | PROJECT_ACCOUNT     | luis                |
      | PROJECT_SAMPLE_DATA | true                |
    Then The project title should be equals ProjectSeleniumTest
