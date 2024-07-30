Feature: Flipkart Search Functionality

  Scenario: Search for a product and verify the results
    Given the user is on the Flipkart homepage
    When the user searches for a product
    Then the search results should be displayed
    And the user adds the product to the cart


  Scenario: Login and verify error message
    Given the user is on the Flipkart login page
    When the user enters an incorrect phone number
    Then an error message should be displayed