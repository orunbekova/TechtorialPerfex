  @regression
Feature: Invoice Management

 # Login with valid credentials.
  #Verify that page title is "Apple LLC"
  #Go to "Invoices" menu from top menu
  #Verify that page title is "Invoices"
  #Verify that new created invoice in TC 8 is received by customer.
  #Verify that status is labeled as "Unpaid" with red font

 @TPX-10
  Scenario: Verify Invoice Creation

    Given User navigates to 'customer' login page
    When User logs in with "customer" credentials
    * User should see the page title "Apple LLC"

    When User clicks "Invoices" menu
    And User verifies that the page title is "Invoices"
    And User verifies that the invoice  "INV-000023" is received by the customer
    Then User verifies that the status is labeled as "Unpaid" and background-color is 'rgba(220, 38, 38, 1)'

    @TPX_21
  Scenario: Verify Paid Invoices
    Given User navigates to 'manager' login page
    When User logs in with "manager" credentials
    And User click Sales Module from left side navigation menu
    And User clicks on the "Invoices" module
      And User filters the invoices by Paid
      And User verifies that the total "Paid" records match the count of displayed "entities" in the bottom of the table
    And User navigates to Dashboard  module
    Then User verifies that "Invoice overview" section shows same number of "Paid" record entities


  #navigate to url: Techtorial CRM - Login
  #Enter correct manager email and password
  #Click "Sales" Module from left side navigation menu
  #Click "Invoices" module
  #From top of the table, click "Filter by" button and filter "Paid" invoices
  #Count total paid record and verify that number is the same with showing entities in the bottom of table.
  #Navigate back to "Dashboard" menu from left menu.
  #Verify that "Invoice overview" section shows same number of "Paid" record entities.