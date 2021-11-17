# Projekt zaliczeniowy Tester Automatyzujący Coders Lab

##Zadanie warsztatowe 1 - Selenium WebDriver + Cucumber (Task01.feature)
Utwórz użytkownika manualnie na stronie https://mystore-testlab.coderslab.pl.

Możesz wykorzystać tymczasowego maila do utworzenia użytkownika https://10minutemail.com/.


Napisz skrypt, który:

1. będzie logować się na tego stworzonego użytkownika,
2. wejdzie klikając w kafelek Addresses po zalogowaniu (adres, na którym powinniśmy się znaleźć to: https://mystore-testlab.coderslab.pl/index.php?controller=addresses ),
3. kliknie w + Create new address,
4. wypełni formularz New address - dane powinny być pobierane z tabeli Examples w Gherkinie (alias, address, city, zip/postal, code, country, phone),
5. sprawdzi czy dane w dodanym adresie są poprawne.

Dodatkowe kroki dla chętnych:

1. usunie powyższy adres klikając w "delete",
2. sprawdzi czy adres został usunięty.

##Zadanie warsztatowe 2 (dowolny sposób Task02.feature)
Napisz skrypt, który:

1. zaloguje się na tego samego użytkownika z zadania 1,
2. wybierze do zakupu Hummingbird Printed Sweater (opcja dodatkowa: sprawdzi czy rabat na niego wynosi 20%),
3. wybierze rozmiar M (opcja dodatkowa: zrób tak żeby można było sparametryzować rozmiar i wybrać S,M,L,XL),
4. wybierze 5 sztuk według parametru podanego w teście (opcja dodatkowa: zrób tak żeby można było sparametryzować liczbę sztuk),
5. dodaj produkt do koszyka,
6. przejdzie do opcji - checkout,
7. potwierdzi address (możesz go dodać wcześniej ręcznie),
8. wybierze metodę odbioru - PrestaShop "pick up in store",
9. wybierze opcję płatności - Pay by Check,
10. kliknie na "order with an obligation to pay",
11. zrobi screenshot z potwierdzeniem zamówienia i kwotą.

Zadanie warsztatowe 2 (dowolny sposób)
Dodatkowe kroki dla chętnych:

1. Wejdź w historię zamówień i detale (najpierw kliknij w użytkownika zalogowanego, później kafelek),
2. sprawdź czy zamówienie znajduje się na liście ze statusem "Awaiting check payment" i kwotą taką samą jak na zamówieniu dwa kroki wcześniej.