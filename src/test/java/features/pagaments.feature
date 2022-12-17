
@tag
Feature: pagaments
  I want to use this template for my feature file

  @tag1
  Scenario Outline: paymet of an hotel
  	Given page is started
    And the user is in the hotel payment page
    When adds the hotel Travellers Information
		And adds the personal <name>, <lastname>, <email>, <phone>, <adress>
		And chooses the payment <method>
		And clicks the confirmation button
		Then I validate the general info <name>, <lastname>, <email>, <phone>, <adress>, <payment>
		And close
		
		Examples:
			| name | lastname | email | phone | adress | method | payment |
			| aaaa | bbbbbbbb | a@aaa | 11223 | aaaaaa | arguments[0].click() | Pay Later |
  
  @tag2
  Scenario Outline: payment of a flight
  	Given page is started
    And the user is in the flight payment page
    When adds the flight Travellers Information
		And adds the personal <name>, <lastname>, <email>, <phone>, <adress>
		And chooses the payment <method>
		And clicks the confirmation button
		Then I validate the general info <name>, <lastname>, <email>, <phone>, <adress>, <payment>
		And I validate the flight info
		And close
			
			
    Examples: 
      | name | lastname | email | phone | adress | method | payment |
			| aaaa | bbbbbbbb | a@aaa | 11223 | aaaaaa | arguments[0].click() | Pay Later |
  

      
  @tag3    
  Scenario Outline: payment tour  
  	Given page is started
    And the user is in the tour payment page
		When adds the tour Travellers Information
		And adds the personal <name>, <lastname>, <email>, <phone>, <adress>
		And chooses the payment <method>
		And clicks the confirmation button
		Then I validate the general info <name>, <lastname>, <email>, <phone>, <adress>, <payment>
    And close
    
    Examples:
    	| name | lastname | email | phone | adress | method | payment |
			| aaaa | bbbbbbbb | a@aaa | 11223 | aaaaaa | arguments[0].click() | Pay Later |
  
    
    
    