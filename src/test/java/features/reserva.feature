Feature: reservaSteps
	@tag1
		Scenario Outline: Reserve a hotel
		
			Given the user log in
			And the user is in the hotel selection
			When the users selects the <Hotel>
			And the user chose the <room>
			Then we validate we are in the correct Hotel and the correct Room
			When adds the hotel Travellers Information
			And adds the personal information
			And chooses the payment method
			And clicks the confirmation button
			Then I validate the booking info
			
		Examples: 
		  | Hotel | room |
		  | //*[@id="fadein"]/section[2]/div/div/div[2]/div/div/div/div[1]/div/div[8]/div | //*[@id="availability"]/div[2]/div | 
		  | //*[@id="fadein"]/section[2]/div/div/div[2]/div/div/div/div[1]/div/div[7]/div | //*[@id="availability"]/div[2]/div |
	@tag2
		Scenario Outline: Reserve a fly
		
			Given the user log in
			And the user is in the fly selection *
			When the users selects the <company>
			And the user chose the <trip>
			Then we validate we are in the correct com and the correct Room
			
			When adds the flight Travellers Information
			And adds the personal information
			And chooses the payment method
			And clicks the confirmation button
			Then I validate the flight info
	@tag3
	
	