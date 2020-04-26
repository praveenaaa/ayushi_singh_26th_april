Feature: scenario outline

Description: The purpose of this feature is to test the order actions

Scenario Outline: For searching product user must be registered and login using valid credentials

Given lalitha has registered in to TestMeApp

When lalitha enter Username as "<username>" and Password as "<password>"

Examples: −
| username  | password  |
| lalitha | password123 |
 
 
Scenario Outline: The one where the user moves to cart without adding any item in it.

   When user search for particular product and enter product name as "<productname>"
 
   And try to proceed the payment without adding any item in cart
  
   Then TestMeApp doesn't display the cart icon

Examples: − 
 | productname |
 | headphone |
      