Feature: Task02

  Scenario: ShoppingCardSteps
    Given user open seccond coderslab website https://mystore-testlab.coderslab.pl
    And user logIn website
    And user find product Hummingbird Printed Sweater
    When user choose Hummingbird Printed Sweater to buy
    And user choose size M
    And user chose 5 products
    And user add product to basket
    And user go to checkout
    And user confirms address
    And user choosing a pick up method - PrestaShop pick up in store
    And user choose a payment method- Pay by Check
    And user clicks in order with an obligation to pay
    Then confirm screenshot order
    And get total order
    And go to history and details
    And check status Awaiting check payment and total order
    And browser closed now