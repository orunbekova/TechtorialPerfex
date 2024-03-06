Feature: Testing proposal acceptance functionality

  Scenario: Verify Proposal Acceptance Process
    Given User navigates to 'customer' login page
    * User should see the page title "Apple LLC"

    When  User clicks on the "Proposals" menu in the top navigation menu
    Then User should verify that the proposal it was created in TC5 is in the list with
      | proposalName | Name_Proposal_Test_TC5 |
      | totalPrice   | $300.30                    |
    And User gets the created proposal ID from the Proposal# column and save it as proposal_id


    When User clicks on the created proposal "Name_Proposal_Test_TC5" from the table
    Then User should verify that the proposal_id matches the value in the h4 tag on the new page
    And User should verify that the page title is "Name_Proposal_Test_TC5"
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