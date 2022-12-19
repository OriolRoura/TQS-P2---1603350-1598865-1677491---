Feature: Modificar configuracio web
		#@tag1
		#Scenario Outline: Steps Modificar configuracio
		
		#Given Estic en la pagina
		#When Apreto idioma <idioma> and <moneda>
		#Then Hauria de veure el idioma espanyol
		#And Close modificar
		
		#Examples:
		#| idioma | moneda | seccio | urlQueTocaria |
		#| //*[@id="fadein"]/header/div/div/div/div/div/div[2]/div/div[2]/div[1]/div/ul/li[8] | //*[@id="fadein"]/header/div/div/div/div/div/div[2]/div/div[2]/div[2]/div/ul/li[4] | //*[@id="tours-tab"] | //*[@id="tours-tab"] |

		
		  
		@tag1
		Scenario Outline: Steps programar vuelo
		
		Given Estic en la pagina
		When Poso la data <data>
		And Indico la resta de funcions del viatge
		Then Hauria de veure el vol <opcio> com a primera opcio
		And Close modificar
		
		Examples:
		| data | opcio |
		|  /html/body/section[1]/div/div/div/div/div[2]/div[2]/div[2]/form/div[2]/div[2]/div/div[1]/div/div/input | |
		
		#@tag3
		#And Entrar en la seccio de prova <seccio>, per tant estem en <urlQueTocaria>
		
	
