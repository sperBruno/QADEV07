Feature: Create Project

  Background: I login into pivotal
    Given I login with credentials valid

    Scenario: Create Project
      When I click on create project
      And I fill the prjeoct title text box with ProjectSeleniumTest
      And I choose an account by default
      And I click on create Project button
      Then A project page with set title ProjectSeleniumTest must appear
