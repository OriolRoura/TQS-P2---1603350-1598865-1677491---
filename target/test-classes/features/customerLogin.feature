Feature: Login

Scenario Outline: Make Login

Given the user is in the logIn page
When the user clikcs the ACCOUNT button
And clicks the Customer Login button
Then the user Logs in
When the user clikcs the MyProfile button 
Then we compare the account email to the one we submited