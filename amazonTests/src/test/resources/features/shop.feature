Feature: Shop
  Scenario: As a user, I should be able to shop at "https://www.amazon.com/"
    Given I am on the main page of Amazon.com
    When I search for the book  "Ender's Game by Orson Scott Card"
    And Click on the book from the search
    And I add the book to the card
    Then Navigate to my cart and verify the book is there
    Then Delete the book from the cart and verify that it is no longer present

