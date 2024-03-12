@regression

Feature: Testing the Proposals functionality
  Background:
    Given User navigates to 'employee' login page
    And User provides 'employee' login and password to the loginPage
    When User click Sales Module from left side navigation menu
    And User Click Proposals module

  Scenario: New Proposal button background color
    Then User validates that there a button New Proposal is visible
    And User validates that New Proposal button background-color is 'rgba(37, 99, 235, 1)'

  Scenario: Create new Proposal Feature
    When  User clicks newProposal button
    And User enters 'Bogdan_Proposal_Test_TC5' in subject line
    And User choose 'Customer' and search&choose 'Apple' & 'Apple LLC' from customer,'#1 - Apple Project - Apple LLC' from Project
    And User choose '(253.00) Asus Monitor' from drop addItem with quantity '1'dropdown and clicks add button
    And User adds '(10.00) Ethernet Cable' from drop addItem with quantity '2'dropdown and clicks add button
    Then User validate that proposals total price is '$300.30'
    When User clicks save&send button
    Then User validates the new proposal is added with 'Sent' and deletes the Proposal

