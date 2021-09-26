Feature: Create new address

  Scenario Outline: User adding new address
    Given user open https://prod-kurs.coderslab.pl/
    When user click on SingIn button
    And user enter email <email> and password <password> and click Signin button
    And user click "add first address" button
    And user add new alias <alias>, firstname <firstname>, surname <lastname>, address <address>, zip code <code>, city <city>, country <country> and phone <phone>
    And user sees confirmation message
    Then browser is closed
    Examples:
      | email        | firstname | lastname | password | alias | address     | code   | city     | country | phone     |
      | 123123@wp.pl | Barrt     | ZSW      | Q123Q23  | alias | Zlotnicza 2 | 21-005 | Warszawa | Polad   | 123456789 |

