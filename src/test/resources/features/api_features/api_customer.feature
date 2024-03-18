Feature: Customer API Validation for successful response

  Scenario: Customer API Response
    Given I have base url "https://techtorialperfex.com/perfexcrm/api" and endpoint "/customers"
    When the user send the "GET" request
    Then verify status code 200
    * verify number of values 5
    * verify response "[1].company" is "Ikea LLC"
    * verify response "[1].userid" is "5"
    * verify api response is ordered by "company"


  Scenario: Verify Proposal total amount
    Given I have base url "https://techtorialperfex.com/perfexcrm/api" and endpoint "/proposals/search/Chicago"
    When the user send the "GET" request
    Then verify status code 200
    * verify response "[0].id" is "3"
    * verify response "[0].subject" is "Chicago Office PC"
    * verify response "[0].total" is "8379.80"

  Scenario: Verify Proposal details (solution1)
    Given I have base url "https://techtorialperfex.com/perfexcrm/api" and endpoint "/proposals/37"
    When the user send the "GET" request
    Then verify status code 200
    * verify response "id" is "37"
    * verify response "subject" is "Cristian_Proposal_Test_TC7"
    * verify response "items" has size "2"
    * verify response "items[0].qty" is "1.00"
    * verify response "items[1].qty" is "2.00"

  Scenario: Verify Proposal details (solution2)
    Given I have base url "https://techtorialperfex.com/perfexcrm/api" and endpoint "/proposals/37"
    When the user send the "GET" request
    Then verify status code 200
    * verify proposal details
      | id           | 37                         |
      | subject      | Cristian_Proposal_Test_TC7 |
      | items[0].qty | 1.00                       |
      | items[1].qty | 2.00                       |
    * verify response "items" has size "2"






    Scenario: Verifying Item List
      Given I have base url "https://techtorialperfex.com/perfexcrm/api" and endpoint "/items/search/"
      When the user send the "GET" request
      Then verify status code 200
      * verify number of values 3
      * verify response "[1].id" is "2"
      * verify response "[1].name" contains "Ethernet Cable"


