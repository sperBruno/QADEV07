Feature: Create Project

  Background: I login into pivotal
    Given I login with valid credentials

  @ProjectSelenium
  Scenario: Create Project
    Given I create a new project
      | PROJECT_TITLE   | ProjectSeleniumTest |
      | PROJECT_ACCOUNT | luis                |
      | PROJECT_VISIBLE | true                |
    Then The project title should be equals ProjectSeleniumTest (Public)
    And I verify that the account of the created project is luis
    And I validate that the created Project is public

  Scenario: Validate Project Title error message
    Given I create a new project
      | PROJECT_ACCOUNT | luis |
      | PROJECT_VISIBLE | true |
    Then A message That says Enter a name for your project should appears


  Scenario: Validate error Account message
    Given I create a new project
      | PROJECT_TITLE   | ProjectSeleniumTest |
      | PROJECT_VISIBLE | true                |
    Then A message That says Please select or create an account for the new project should appears

  @ProjectSelenium
  Scenario: Validate the Creation of the Project with Sample Data checkbox enabled.
    Given I create a new project
      | PROJECT_TITLE       | My Sample Project |
      | PROJECT_ACCOUNT     | Bruno               |
      | PROJECT_SAMPLE_DATA | true                |
    Then The project title should be equals My Sample Project
    And I verify that the account of the created project is Bruno
    And I validate that the created Project is private
