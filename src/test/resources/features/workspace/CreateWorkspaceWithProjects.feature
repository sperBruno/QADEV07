Feature: Workspace with Projects

  Background: I have projects created
    Given I send a POST request to /projects
      | name   | test |
      | public | true |
    Given I login with valid credentials
    When I am on Pivotal Dashboard page

  @project
  Scenario: Add project to Workspace created

    Given I am on Pivotal Create Workspace form
    When I fill with My Workspace8 the name Workspace field
    And click on the Create Workspace button of the Form
    When I click on Add Projects button
    And I  click on list projects icon
    When I select the project created previously
    And I click on Save Workspace button
    Then I expect a workspace with the test project name