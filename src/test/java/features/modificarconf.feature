Feature: Modificar configuracio web
		@tag1
		Scenario Outline: Steps Modificar configuracio
		
		Given Estic en la pagina
		When Apreto idioma <idioma> and <moneda>
		Then Hauria de veure el idioma espanyol
		And Close modificar
		
		Examples:
		| idioma | moneda |
		| //*[@id="fadein"]/header/div/div/div/div/div/div[2]/div/div[2]/div[1]/div/ul/li[8] | //*[@id="fadein"]/header/div/div/div/div/div/div[2]/div/div[2]/div[2]/div/ul/li[4] |

		
		  
		@tag2
		Scenario Outline: Steps programar vuelo
		
		Given Estic en la pagina
		When Poso la data <data>
		And Indico la resta de funcions del viatge
		Then Hauria de veure la URL
		And Close modificar
		
		Examples:
		| data | companyia | codi |
		|  //*[@id="departure"] | Vueling | 1002 |
		
		#@tag3
		#And Entrar en la seccio de prova <seccio>, per tant estem en <urlQueTocaria>
		
	
