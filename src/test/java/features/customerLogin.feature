Feature: Login
@tag1
Scenario Outline: Make Login

Given the user is in the logIn page
When the user clikcs the ACCOUNT button
And clicks the Customer Login button <Type>
Then the user Logs in <Email> <Password>
When the user clikcs the MyProfile button 
Then we compare the account email to the one we submited
And close

Examples: 
| Type | Email | Password |
| Customer Login | user@phptravels.com | demouser |
| Agents Login | agent@phptravels.com | demoagent |
| Supplier Login | supplier@phptravels.com | demosupplier |



@tag2
Scenario Outline: Failed Login

Given the user is in the logIN page
When the user clicks the ACCOUNT button
And clicks the Customer button <Type>
Then the user Logs in wrong <Email> <Password>
And close

Examples: 
| Type | Email | Password |
| Customer Login | random@123.com | random123 |
| Agents Login | user@phptravels.com | demouser |
| Agents Login | random@123.com | random123 |
| Supplier Login | user@phptravels.com | demouser |
| Supplier Login | random@123.com | random123 |
