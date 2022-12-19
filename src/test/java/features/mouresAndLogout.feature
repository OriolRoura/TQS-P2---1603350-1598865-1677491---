Feature: Moves

@tag1
Scenario Outline: Make moves and Logout

Given çthe user is in the logIn page
When çthe user clikcs the ACCOUNT button
And çclicks the Customer Login button <Type>
And çthe user Logs in <Email>,<Password>
And çthe user click different parts of webpage
And çthe user Logout

Examples: 
| Type | Email | Password |
| Customer Login | user@phptravels.com | demouser |