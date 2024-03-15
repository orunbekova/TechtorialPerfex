Feature: Customer API Validation for successful response

  Scenario: Customer API Response
    Given I have base url "https://techtorialperfex.com/perfexcrm/api" and endpoint "/customers"
    When the user send the "GET" request
    Then verify status code 200
    * verify number of values 5
    * verify response "[1].company" is "Ikea LLC"
    * verify response "[1].userid" is "5"
    * verify api response is ordered by "company"



    Scenario: Verify Item List
      Given I have base url "https://techtorialperfex.com/perfexcrm/api" and endpoint "/items/search/"
      When the user send the "GET" request
      Then verify status code 200
      * verify number of values 3
      * verify response "[1].name" is "(10.00) Ethernet Cable"


  Scenario: Verify Proposal total amount
    Given I have base url "https://techtorialperfex.com/perfexcrm/api" and endpoint "/proposals/search/Chicago"
    When the user send the "GET" request
    Then verify status code 200
    * verify response "[0].id" is "3"
    * verify response "[0].subject" is "Chicago Office PC"
    * verify response "[0].total" is "8379.80"




