Feature: Workspace

  Scenario: Create a project with a name valid

    Given I am on Pivotal Create Workspace form
    When I fill with My Workspace5 the name Workspace field
    And click on the Create Workspace button of the Form
    Then the display name equals to My Workspace5