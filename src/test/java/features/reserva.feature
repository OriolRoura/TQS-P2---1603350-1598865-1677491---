Feature: reserva
	@tag1
		Scenario Outline: Reserve a hotel
		
			Given the user log in
			And the user is in the hotel selection
			When the users selects the hotel <Hotel>
			And the user chose the hotel <room>
			Then we validate we are in the correct Hotel and the correct Room
			And close1	
			
		Examples: 
		  | Hotel | room |
		  | //*[@id="fadein"]/section[2]/div/div/div[2]/div/div/div/div[1]/div/div[8]/div | //*[@id="availability"]/div[2]/div |
		  | //*[@id="fadein"]/section[2]/div/div/div[2]/div/div/div/div[1]/div/div[7]/div | //*[@id="availability"]/div[2]/div |
	
	@tag2
		Scenario Outline: Reserve a flight
		
			Given the user log in
			And the user is in the fly selection
			When the users selects the flight <company>
			And the user chose the flight <trip>
			Then we validate we are in the company flight and the correct flight
			And close1
			
		Examples:
			| company | trip |
			| //*[@id="new-york"]/div/div[2]/a | //*[@id="data"]/ul/li[1]/div/form/div |

	@tag3
		Scenario Outline: Reserve a tour
			Given the user log in
			And the user is in the tour selection
			When the users selects the tour <destination>
			And the user chose the tour participants <adults>, <infant>, <childs>
			Then we validate we are in the tour
			And close1
		Examples:
			| destination | trip | adults | infant | childs |
			| //*[@id="fadein"]/section[2]/div/div/div[2]/div[1]/div/div[1]/a[1] | //*[@id="data"]/ul/li[1]/div/form/div | 2 | 2 | 1 |
	
	