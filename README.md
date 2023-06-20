# Pizza Store MVP demo #

## Source ##
https://github.com/scudsucker/pizzashop

In order to supply some handwritten code of my own, I decided to create an "interview style test".

## User Story ##
Scenario: a restaurant point of sale needs to provide an accurate bill at the end of the night, for an arbitrary number of people eating.

For simplicity, the menu is;

- Pizza : R100.00
- Beer: R47.50  (craft beer!)
- Tap Water: Free

Value Added Tax is 14.5%

When asked by management to take his software development team to the restaurant to celebrate a big release, calculate the total cost to the team lead's entertainment budget, noting tax.

## NOTES ##

In a real world scenario, this test would use product code/ids and call from a database. As this is just a simple minimum viable product I chose to use the product name as an identifier.

in the file `/src/main/java/models/MenuItem.java`, there is a GETTER for the name which is not used. I chose to include it in order that the bill can be listed at some future point.