Feature: Create Project

  Background: I login into pivotal
    Given I login with credentials valid

    
    Scenario: Create Project
      When I click on create project
      And I fill the project title text box with ProjectSeleniumTes
      And I choose an account by default
      And I click on create Project button
      Then A project page with set title ProjectSeleniumTes must appear
