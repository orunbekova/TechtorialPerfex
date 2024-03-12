@regression

Feature: Testing the Invoice functionality
  Scenario:
    Given User navigates to 'employee' login page
    And User provides 'employee' login and password to the loginPage
    When User click Sales Module from left side navigation menu
    And User Click Proposals module
      When  User clicks newProposal button
    And User enters 'Bogdan_Proposal_Test_TC5' in subject line
    And User choose 'Customer' and search&choose 'Apple' & 'Apple LLC' from customer,'#1 - Apple Project - Apple LLC' from Project
    And User choose '(253.00) Asus Monitor' from drop addItem with quantity '1'dropdown and clicks add button
    And User adds '(10.00) Ethernet Cable' from drop addItem with quantity '2'dropdown and clicks add button
    When User clicks save&send button
    When User Logs Out as employee
    And User navigates to 'customer' login page
    And User provides 'customer' login and password to the loginPage
    When  User clicks on the "Proposals" menu in the top navigation menu
    When User clicks on the created proposal "Bogdan_Proposal_Test_TC5" from the table
    When User clicks the Accept button
    And User  clicks the Sign button on the pop-up screen
    And User draws a signature in canvas
    When User clicks sign button
    And User click back to Portal
    When User Logs Out as a customer
    And User navigates to 'employee' login page
    And User provides 'employee' login and password to the loginPage
    When User click Sales Module from left side navigation menu
    And User Click Proposals module
    And User search 'Bogdan_Proposal_Test_TC5' in proposals
    Then User validates 'Bogdan_Proposal_Test_TC5' 'Apple Project' 'Accepted'
    And User Click associated proposal id from proposal column
    And User clicks comments enters 'Bogdan_Proposal_Test_TC5 is accepted for invoice' & clicks Add comment
     Then User verifies that next to Comments tab there is '1' badge for total comment
     When User Click Convert button and Select Invoice button from drop down menu.
  Then User Verifies that Customer is 'Apple LLC' as default and Scrools down page and clicks Save button
  Then User verifies that there is red 'Unpaid' label next to record header
    And User Verifies that record header that starts with INV- same number with Invoice Number section in the form
    And User deletes invoice
    When User click Sales Module from left side navigation menu
    And User Click Proposals module
    And User search 'Bogdan_Proposal_Test_TC5' in proposals
    And User Click associated proposal id from proposal column
    And User deletes proposal









  
Feature: Invoice Management


 @TPX-10
  Scenario: Verify Invoice Creation

    Given User navigates to 'customer' login page
    When User logs in with "customer" credentials
    * User should see the page title "Apple LLC"

    When User clicks "Invoices" menu
    And User verifies that the page title is "Invoices"
    And User verifies that the invoice  "INV-000023" is received by the customer
    Then User verifies that the status is labeled as "Unpaid" and background-color is 'rgba(220, 38, 38, 1)'


 # Login with valid credentials.
  #Verify that page title is "Apple LLC"
  #Go to "Invoices" menu from top menu
  #Verify that page title is "Invoices"
  #Verify that new created invoice in TC 8 is received by customer.
  #Verify that status is labeled as "Unpaid" with red font

