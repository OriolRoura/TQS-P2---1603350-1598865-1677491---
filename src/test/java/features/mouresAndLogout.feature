Feature: Moves

@tag1
Scenario Outline: Make moves and Logout

Given the user is in the logIn page
When the user clikcs the ACCOUNT button
And clicks the Customer Login button <Type>
And the user Logs in <Email>,<Password>
And the user click different parts of webpage
And the user Logout
And close

Examples: 
| Type | Email | Password |
| Customer Login | user@phptravels.com | demouser |