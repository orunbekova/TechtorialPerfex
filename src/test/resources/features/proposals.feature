@regression

Feature: Testing the Proposals functionality
  Background:
    Given User navigates to 'employee' login page
    And User provides 'employee' login and password to the loginPage
    When User click Sales Module from left side navigation menu
    And User Click Proposals module

  Scenario: New Proposal button background color
    Then User validates that there a button New Proposal is visible
    And User validates that New Proposal button background-color is 'rgba(37, 99, 235, 1)'