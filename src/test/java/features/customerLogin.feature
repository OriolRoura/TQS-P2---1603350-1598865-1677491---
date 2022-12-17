Feature: Login

Scenario Outline: Make Login

Given the user is in the index page
When the user clikcs the ACCOUNT button
And clicks the Customer Login button
Then the user Login
When the user clikcs the ACCOUNT button when logged
And the user clikcs the MyProfile button 
Then we compare the account email to the one we submited