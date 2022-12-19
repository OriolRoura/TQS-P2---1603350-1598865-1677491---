
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
		And close2
		
		Examples:
			| name | lastname | email | phone | adress | method | payment |
			| aaaa | bbbbbbbb | a@aaa | 11223 | aaaaaa | //*[@id="myTab"]/label/label/label/label/label | Pay Later |
  		| antonio | apaca | aa@p | 44532 | London | //*[@id="myTab"]/label/label/label/label | Wallet Balance |
  		| 1154 | 24423357 | a@aaa | 11223 | aaaaaa | //*[@id="myTab"]/label/label/label/label/label | Pay Later |
  		| aaaa | bbbbbbbb | a@aaa | aaase | aaaaaa | //*[@id="myTab"]/label/label/label/label/label | Pay Later |
  		| aaaa | bbbbbbbb | a@aaa | | aaaaaa | //*[@id="myTab"]/label/label/label/label/label | Pay Later |
 			| aaaa | bbbbbbbb | a@aaa | 5444317 |  | //*[@id="myTab"]/label/label/label/label/label | Pay Later |
   
  		
  @tag2
  Scenario Outline: payment of a flight
  	Given page is started
    And the user is in the flight payment page
    When adds the flight Travellers Information
		And adds the personal <name>, <lastname>, <email>, <phone>, <adress>
		And chooses the payment <method>
		And clicks the confirmation button
		Then I validate the general info <name>, <lastname>, <email>, <phone>, <adress>, <payment>
		And close2
			
			
    Examples: 
      | name | lastname | email | phone | adress | method | payment |
			| aaaa | bbbbbbbb | a@aaa | 11223 | aaaaaa | //*[@id="myTab"]/label |Razorpay|
  

      
  @tag3    
  Scenario Outline: payment tour  
  	Given page is started
    And the user is in the tour payment page
		When adds the tour Travellers Information
		And adds the personal <name>, <lastname>, <email>, <phone>, <adress>
		And chooses the payment <method>
		And clicks the confirmation button
		Then I validate the general info <name>, <lastname>, <email>, <phone>, <adress>, <payment>
    And close2
    
    Examples:
    	| name | lastname | email | phone | adress | method | payment |
			| aaaa | bbbbbbbb | a@aaa | 11223 | aaaaaa | //*[@id="myTab"]/label/label/label/label/label | Pay Later |
  	
    @tag

  @tag4
  Scenario Outline: paymet without some values
  	Given page is started
    And the user is in the hotel payment page
    When adds the hotel Travellers Information
		And adds the personal <name>, <lastname>, <email>, <phone>, <adress>
		And chooses the payment <method>
		And clicks the confirmation button
		Then validate empty cage
		And close2
		
		Examples:
			| name | lastname | email | phone | adress | method | payment |
			|  |  | a@aaa | 11223 | aaaaaa | //*[@id="myTab"]/label/label/label/label/label | Pay Later |
  		| aaaa | bbbbbbbb |  | 11223 | aaaaaa | //*[@id="myTab"]/label/label/label/label/label | Pay Later |
  		
  @tag5
  Scenario Outline: payment with bad email
  	Given page is started
    And the user is in the flight payment page
    When adds the flight Travellers Information
		And adds the personal <name>, <lastname>, <email>, <phone>, <adress>
		And chooses the payment <method>
		And clicks the confirmation button
		Then validate email error 
		And close2
			
			
    Examples: 
      | name | lastname | email | phone | adress | method | payment |
			| aaaa | bbbbbbbb | aaa | 11223 | aaaaaa | //*[@id="myTab"]/label/label/label/label/label | Pay Later |

    