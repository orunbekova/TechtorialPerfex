@regression
Feature: Testing proposal acceptance functionality

  Scenario: Create a new proposal with specified details in datatable
    Given User navigates to 'employee' login page
    When User logs in with "employee" credentials
    Then User clicks on the "Sales" module from the left side navigation menu
    And User clicks on the "Proposals" module
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

  Scenario: Verify Proposal Acceptance Process
    Given User navigates to 'customer' login page
    When User logs in with "customer" credentials
    * User should see the page title "Apple LLC"

    When  User clicks on the "Proposals" menu in the top navigation menu
    Then User should verify that the proposal it was created in TC5 is in the list with
      | proposalName | Constantin_Proposal_Test_TC5 |
      | totalPrice   | $300.30                      |
    And User gets the TPX5 proposal ID from the Proposal# column and save it as proposal_id
    When User clicks on the created proposal on TPX5 from the table
    Then User should verify that the proposal_id matches the value in the h4 tag on the new page
    And User should verify that the page title is "Constantin_Proposal_Test_TC5"
    And User should verify that the first item in the table is "Asus Monitor" and that the second item in the table is "Ethernet Cable"
    And User should see an Accept button on the page

    When User clicks the Accept button
    And User  clicks the Sign button on the pop-up screen
    Then User should verify that will get red signature error message  under signature box
      | message | Please sign the document. |
      | color   | rgba(239, 68, 68, 1)      |
    And User draws a signature in canvas
    When User clicks sign button
    Then User should verify that they get "Accepted" status label with "rgba(240, 253, 244, 1)" background color next to proposal id.


  Scenario: Delete proposal created in TPX5
    Given User navigates to 'employee' login page
    When User logs in with "employee" credentials
    Then User clicks on the "Sales" module from the left side navigation menu
    And User clicks on the "Proposals" module
    And User clicks and deletes the proposal created in TPX5