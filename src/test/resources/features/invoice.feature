  @regression
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