Feature: Company

@tag1
Scenario Outline: Entrem diferent seccions Company

Given the user is in the main page
When the user clikcs the Company button
Then clicks the Company option button <Type>
And close

Examples: 
| Type |
| About Us | 
| Terms Of Use | 
| About Us | 
| How To Book |
