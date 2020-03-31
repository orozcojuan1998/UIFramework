Feature: Shopping Cart

  Background: Login
    Given The user is in the application home page logged in

  Scenario: Test add product to cart
    Given  The user has look for "crema facial" in the search bar
    When The user adds a displayed product to his shopping cart
    Then The user is informed that the product was added to the cart
    And The user delete the product of the shopping cart

  Scenario: Test to delete the only product in the cart
    Given The user has look for "cuchara" in the search bar
    When The user adds a displayed product to his shopping cart
    And The user delete the product of the shopping cart
    Then The user is informed that its shopping cart is empty

