@regression
Feature: Expense Management


  Scenario: Recording an expense for a customer
    Given User navigates to 'manager' login page
    When User logs in with "manager" credentials
    And User clicks on the "Expenses" module from the left side navigation menu
    Then User should see the page title as "Expenses"
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
