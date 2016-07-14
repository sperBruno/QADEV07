Feature: Create Project

  Background: I login into pivotal
    Given I login with credentials valid

  @ProjectSelenium
  Scenario: Create Project
    Given I create a new project
      | PROJECT_TITLE   | ProjectSeleniumTest |
      | PROJECT_ACCOUNT | Jala                |
    Then The project title should be equals ProjectSeleniumTest
