@regression

Feature: Testing the Proposals functionality
  Background:
    Given User navigates to 'employee' login page
    And User provides 'employee' login and password to the loginPage
    When User click Sales Module from left side navigation menu
    And User Click Proposals module

  Scenario: Verify approved proposal
    Given User set Table length "All" from drop down menu
    Then User validates "Accepted" in Proposal status