Feature: Create new address

  Scenario Outline: User adding new address

    Given user open coderslab website https://mystore-testlab.coderslab.pl
    And user clicks on SignIn button and add email and password
    When click Addres after logIn
    And click in Create new address
    And adding values to the address fields <alias>, <address>, <city>, <postcode>, <country>, <phone>
    Then adress <alias> added
    And click delete adress <alias>
    And adress <alias> deleted
    And browser closed

    Examples:
      | alias        | address     | city     | postcode | country        | phone      |
      | Adres domowy | Targowa 11a | Warszawa | 21-010   | United Kingdom | 1234567890 |

