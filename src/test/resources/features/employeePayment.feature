Feature: Employee can not complete payment of invoice


    Background:
    Given User navigates to 'employee' login page
  Scenario:
    And User provides 'employee' login and password to the loginPage
    When User click Sales Module from left side navigation menu
    And User clicks on the "Invoices" module
    And User searches for the invoice ID "INV-000022" created in TC8 in invoices page and click
    Then Verify that there is no "Payment" button next to the dropdown menu
