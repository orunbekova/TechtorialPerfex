@regression
Feature: Expense Management
Background:
  Given User navigates to 'manager' login page
  When User logs in with "manager" credentials
  And User clicks on the "Expenses" module from the left side navigation menu
  Then User should see the page title as "(1) Expenses"

  Scenario: Recording an expense for a customer
#    Given User navigates to 'manager' login page
#    When User logs in with "manager" credentials
#    And User clicks on the "Expenses" module from the left side navigation menu
#    Then User should see the page title as "Expenses"
    When User clicks on the + Record Expense button
    And User creates a new record with the following details:
      | Field            | Value                            |
      | Expense Name     | Apple Meal Expense               |
      | Note             | Expenses added for Apple project |
      | Expense Category | Meals                            |
      | Amount           | 50                               |
      | Customer         | Apple LLC                        |
      | Project          | #1 - Apple Project - Apple LLC   |
      | Payment Mode     | Bank                             |
    And User scrolls down and select the Save button
    Then User should see the expense recorded and listed in the Expense module
    And User should find the created expense with the note "Expenses added for Apple project"
    And User should verify that the Created by record has the same name as the user's First and Last name displayed on the account icon on the top menu when hovered over

    Scenario: User veify view record on expenses page

      When hover over record category column
      Then verify is shows "View | Edit | Delete"
      When selecet View option
      Then verify that new panel show up expenses detail
      Then verify new panel hide when you click >> icon
      Then verify it shows up back when you clcik yable togle button