@regression
Feature: Create New Proposal for a customer

  Background:
    Given User navigates to 'employee' login page
    When User logs in with "employee" credentials
    Then User clicks on the "Sales" module from the left side navigation menu
    And User clicks on the "Proposals" module

  Scenario: Create a new proposal with specified details datatable

    And User creates new proposal with following data
      | Subject     | Constantin_Proposal_Test_TC5   |
      | Related     | Customer                       |
      | Customer    | Apple LLC                      |
      | Project     | #1 - Apple Project - Apple LLC |
      | ItemSelect1 | (253.00) Asus Monitor          |
      | ItemSelect2 | (10.00) Ethernet Cable         |
      | Quantity    | 2                              |
      | Total       | $300.30                        |
    Then Find created Proposal and verify that its status is "Sent"

  Scenario: Delete proposal created in TPX5

    And User clicks and deletes the proposal created in TPX5

