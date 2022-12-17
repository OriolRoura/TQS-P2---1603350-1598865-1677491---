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
    
    @When("Apreto idioma espanyol")
    public void apreto_idioma_espanyol(){
    	driver.findElement(By.id("languages")).click();
    	driver.findElement(By.xpath("//*[@id=\"fadein\"]/header/div/div/div/div/div/div[2]/div/div[2]/div[1]/div/ul/li[8]/a")).click();
    }
    
    @Then("Hauria de veure el idioma espanyol")
    public void veure_idioma_correcte(){
    	String language = driver.findElement(By.id("languages")).getText();
    	Assert.assertTrue(language.contains("SPANISH")); 
    }




}