@tag
Feature: Submit Order from ECommerce


Background:
Given I landed on LoginPage

@Regression
Scenario Outline:Positive Test for Submitting Order
Given Logged in with UserName <name> and Password <password>
When I add product <productname> to cart
And checkout <productname> and submit order
Then "THANKYOU FOR THE ORDER." message is displayed on confirmation page




Examples:
  | name           | password | productname    |
  | vcb91@gmail.com| Test@123 |ADIDAS ORIGINAL | 
