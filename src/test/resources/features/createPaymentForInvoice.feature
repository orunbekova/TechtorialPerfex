Feature: Create a payment as manager for created invoice

  Background:
    Given User navigates to 'manager' login page
    When User logs in with "manager" credentials
    Then User clicks on the "Sales" module from the left side navigation menu

  Scenario: Make a payment for an invoice as a manager
#    Given User navigates to 'manager' login page
#    When User logs in with "manager" credentials
#    Then User clicks on the "Sales" module from the left side navigation menu
    And User clicks on the "Invoices" module
    And User searches for the invoice ID "INV-000022" created in TC8
    And User selects the found invoice ID "INV-000022" from the Invoice# column
    Then User verifies that there is a Payment button of color "rgba(34, 197, 94, 1)"
    And User clicks the Payment button
    And User validates that there is an account icon on top of the page
    When User hovers over the account icon with a blank person image, it shows the name of the user "David Techtorial"
    Then User adds the user's first and last name from the account icon and "accepted payment" to the payment's Leave a note section
    And User clicks the green "rgba(34, 197, 94, 1)" Save button

    Scenario: Verify a payment as manager

      When User clicks on the "Payments" module
      And User searches for the invoice ID "INV-000022" created in TC8 payment page
      And User selects the found invoice ID "INV-000022" from the Invoice# column in payment page
      Then User verifies that Payment button is disabled
      Then User verifies Paid label is displayed under Invoices tab in right panel
      Then User verifies that a payment badge "1" added next to Payment tab
      When User clicks on the "Payments" on selected invoice
      Then verify payment mode is "Bank" and paid amount is "$300.30"





