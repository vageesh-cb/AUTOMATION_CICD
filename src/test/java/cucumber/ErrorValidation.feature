@tag 
Feature:Validate Login Error Message

Background:


@ErrorValidation
Scenario Outline:Test for Login Error Validation
Given I landed on LoginPage
When  Logged in with UserName <name> and Password <password>
Then "Incorrect email or password." message is displayed

Examples:
  | name           | password  |
  | vcb91@gmail.com| Test@1234 |

		