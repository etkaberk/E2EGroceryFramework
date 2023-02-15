Feature: Get product API

  Scenario Outline: Get Products
    Given : Category "<name>" "<results>"
    When : user calls GET API
    Then :check if the status code is 200
    And : get first product's id
    Examples:
      | name    | results |
      | seafood | 3       |
      | candy   | 5       |
