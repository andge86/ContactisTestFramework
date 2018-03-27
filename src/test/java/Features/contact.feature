Feature: Contact form Feature

As a client I want the ability to ask about products through contact form


Scenario: Client can see Contact form fields

Given Client is on Contactis main page
When Client navigates to Kontakt page
Then Contact form is opened
Then Client can see fields Imie i nazwisko, Adres e-mail, Numer telefonu, Tresc wiadomosci




Scenario Outline: Client can fill Contact form

Given Client is on Contactis main page
When Client navigates to Kontakt page
Then Client can fill Contact form with "<name>", "<email>", "<phone>", "<message>"

Examples: Valid name, email, phone and message

| name       | email           | phone        | message               |
| Andrzej No | andno@gnail.com | +48111222333 | Hi! This is test text |