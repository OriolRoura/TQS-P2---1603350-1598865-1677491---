Feature: Login
@tag1
Scenario Outline: Make Login Client/Agent

Given the user is in the logIn page
When the user clikcs the ACCOUNT button
And clicks the Customer Login button <Type>
And the user Logs in <Email>,<Password>
Then we compare the <user> email to the one we submited
And close

Examples: 
| Type | Email | Password | user |
| Customer Login | user@phptravels.com | demouser | Елена |
| Agents Login | agent@phptravels.com | demoagent | Demo |


@tag2
Scenario Outline: Make Login Supplier
Given the user is in the logIn page
When the user clikcs the ACCOUNT button
And clicks the Customer Login button <Type>
And the user Logs in <Email>,<Password>
And the user clikcs the MyProfile button 
Then we compare the account email to the one we submited supplier
And close

Examples:
| Type | Email | Password |
| Supplier Login | supplier@phptravels.com | demosupplier |

	
@tag3
Scenario Outline: Failed Login

Given the user is in the logIn page
When the user clikcs the ACCOUNT button
And clicks the Customer Login button <Type>
Then the user fails LogIn <Email>, <Password>
And close

Examples: 
| Type | Email | Password |
| Customer Login | random@123.com | random123 |
| Agents Login | random@123.com | random123 |
| Supplier Login | user@phptravels.com | demouser |
| Supplier Login | random@123.com | random123 |
