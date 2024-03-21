Feature: Create New Proposal for a customer
  Background:
  Scenario: Create new proposal
    Given I have base url "https://techtorialperfex.com/perfexcrm/api" and endpoint "/proposals"
    And the request has "proposals" data
    When the user send the "POST" request
    * verify status code 200
    * verify response "message" is "Proposal Added Successfully"
