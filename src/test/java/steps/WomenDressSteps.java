package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WomenDressSteps {

	WebDriver driver;
	
    @Given("the user is in the index page")
    public void theUserIsInTheIndexPage() {
    	System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.get("https://automationexercise.com");
    }

    @When("the user clikcs the products option")
    public void theUserClicksTheProductsOpinion() {
    	driver.findElement(By.partialLinkText("Products")).click();
    }

    @And("the user enters dress in the search bar")
    public void theUserEntersDressInTheSearchBar(String article) {
    	driver.findElement(By.id("search_product")).sendKeys(article);
    }

    @And("the user clicks the search button")
    public void theUserClicksTheSearchButt() {
    	driver.findElement(By.id("submit_search")).click();
    }
    
    @Then("the dress list appears")
    public void theDressListAppears() {
    	String title = driver.findElement(By.className("features_items")).getText();
    	Assert.assertTrue(title.contains("SEARCHED PRODUCTS"));
    }

}