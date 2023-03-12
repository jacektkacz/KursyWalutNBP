
# Kursy walut NBP

Kursy walut NBP is a desktop application made with Java language and JavaFX library to make enquiries on datasets published by Narodowy Bank Polski (National Bank of Poland) and present them in a readable way.

The following datasets can be received from the nbp.pl API service:

Current and historic exchange rates of foreign currencies:
- table A of middle exchange rates of foreign currencies,
- table B of middle exchange rates of foreign currencies,
- table C of buy and sell prices of foreign currencies.

Queries are created to recive replies in the XML format.


## How it works

Application has 3 separated tabs to represent different data.

"Tabele A i B" tab contains single table with 3 columns:
- "Nazwa waluty" - currency name in Polish language;
- "Kod waluty" - three letter currency code (ISO 4217 standard);
- "Kurs średni" - average exchange rate in Polish złoty.

To recive the complete data for currency exchange rates, user needs to select expected date, choose table A or B, and click the button "Pobierz dane" (Download data). 

If data doesn't exist with selected date and table name (A or B), application will show info "Brak danych - proszę wybrać inną datę" (No data - please select different date).

User can also save downloaded data as a excel file by pressing button "Zapisz jako plik Excel".

"Tabela C" tab contains single table with 4 columns:
- "Nazwa waluty" - currency name in Polish language;
- "Kod waluty" - three letter currency code (ISO 4217 standard);
- "Kurs kupna" - buy price of foreign currencies in Polish złoty;
- "Kurs sprzedaży" - sell price of foreign currencies in Polish złoty.

"Waluty" tab contains single line chart. It will show how buy and sale prices of selected currency has changed in last 10 days. Currently user can choose only one currency (USD). Work still in progress.
## Tech Stack

Java 19, JavaFX, Gluon Scene Builder


## Still working on...
- "Waluty" tab: more currencies, download last 10 buy and sale prices from user-selected date, save data as a excel file;
- "Tabele A i B" and "Tabela C" tabs: if data doesn't exist (with selected date), application will send querry to show last known data;
- Exetucable file (currently works only if downloaded and run with IDE).
