package steps;

import java.time.Duration;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class modificarconfSteps {
	WebDriver driver;
	JavascriptExecutor executor;

	
    @Given("Estic en la pagina")
    public void estic_en_la_pagina_correcte(){
    	System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
    	executor = (JavascriptExecutor)driver;
    	driver = new ChromeDriver();
    	driver.get("https://phptravels.net");
    	driver.manage().window().maximize();
    }
    
    @When("^Apreto idioma (.*) and (.*)")
    public void apreto_idioma(String idioma, String moneda){
    	driver.findElement(By.id("languages")).click();
    	driver.findElement(By.xpath(idioma)).click();
    	driver.findElement(By.id("currency")).click();
    	driver.findElement(By.xpath(moneda)).click();
    }
    
    @Then("Hauria de veure el idioma espanyol")
    public void veure_idioma_i_moneda_correcte(){
    	String language = driver.findElement(By.id("languages")).getText();
    	Assert.assertTrue(language.contains("SPANISH"));
    	String moneda = driver.findElement(By.id("currency")).getText();
    	Assert.assertTrue(moneda.contains("EUR"));
    }
    
	@And("^Entrar en la seccio de prova (.*), per tant estem en (.*)")
	public void diferents_seccions(String seccio, String urlQueTocaria) {
		driver.findElement(By.xpath(seccio)).click();
		String urlActual = driver.getCurrentUrl();
		String valor = driver.findElement(By.xpath("//*[@id=\"Tab\"]/li[3]")).getText();
		System.out.print(valor);
		Assert.assertEquals(urlActual, urlQueTocaria);
	}
    
    @And("Close modificar")
	public void close() {
		driver.close();
	}
    
    
    
   
	@When ("^Poso la data (.*)")
	public void posar_data(String data) 
	{
		driver.findElement(By.id("flights-tab")).sendKeys(Keys.RETURN);
		//depleguem calendari i posem 29 de desembre*/
		driver.findElement(By.xpath(data)).click();
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[12]/div[1]/table/tbody/tr[5]/td[5]")).click();
	}
	
	@And("Indico la resta de funcions del viatge")
	public void indicar_valors_hotel()
	{
		/*Des de Barcelona, Fins Madrid*/
		driver.findElement(By.xpath("//*[@id=\"onereturn\"]/div[1]/div/div[1]/div/div/div"));
		driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[2]/div[2]/div[2]/form/div[2]/div[1]/div/div[1]/div/div/div/input"))
		.sendKeys("BCN - Barcelona - Barcelona");
		driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[2]/div[2]/div[2]/form/div[2]/div[1]/div/div[2]/div/div[2]/div/input"))
		.sendKeys("MAD - Barajas - Madrid");
		/*Despleguem travelers i afegim un 2n adult*/
		driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[2]/div[2]/div[2]/form/div[2]/div[3]/div/div/div/a")).click();
		driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[2]/div[2]/div[2]/form/div[2]/div[3]/div/div/div/div/div[1]/div/div/div[2]/i")).click();
		/*Busqueda*/
		driver.findElement(By.id("submit")).click();
		}
	
	@Then ("^Hauria de veure el vol (.*) com a primera opcio")
	public void veure_vol_correcte(String volCorrecte) 
	{
		
	}
    
    
    
}