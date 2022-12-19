Feature: Company

@tag1
Scenario Outline: Entrem diferent seccions Company

Given the user is in the main page
When the user clikcs the Company button
Then clicks the Company option button <Type>
And close4

Examples: 
| Type |
| About Us | 
| Terms Of Use | 
| FAQ | 
| How To Book |
