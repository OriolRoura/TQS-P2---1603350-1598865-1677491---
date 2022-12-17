package steps;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class customerLoginSteps {

	WebDriver driver;
	
 @Given("the user is in the index page")
    public void theUserIsInTheIndexPage() {
    	System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.get("https://phptravels.net/");
    }
 
 @When("the user clikcs the ACCOUNT button")
    public void theUserClicksTheAccountButton() {
    	driver.findElement(By.partialLinkText("ACCOUNT")).click();
    }

 @And("the user clikcs the Customer Login button ")
    public void theUserClicksTheLoginButton() {
    	driver.findElement(By.partialLinkText("Customer Login")).click();
    }
 
 @Then("the user log in")
    public void theUserLogIn(){
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("user@phptravels.com");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("demouser");
        driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[4]/div/div[2]/div[2]/div/form/div[3]/button")).click();
        String expectedUrl= driver.getCurrentUrl();
        String actualUrl="https://phptravels.net/account/dashboard";
        Assert.assertEquals(expectedUrl,actualUrl);
    }
    
 @When("the user clikcs the ACCOUNT button when logged")
    public void theUserClicksTheAccountButtonWhenLogged(){
		driver.findElement(By.partialLinkText("ACCOUNT")).click();
    }

 @And("the user clikcs the MyProfile button ")
    public void theUserClicksTheMyProfileButton() {
    	driver.findElement(By.partialLinkText("My Profile")).click();
    	String expectedMail = "user@phptravels.com";
    	String Mail = driver.findElement(By.cssSelector("input[name='email']")).getText();
    	Assert.assertEquals(expectedMail,Mail);
    	
    }
    
 @Then("We compare the account email to the one we submited")
    public void WeCompareTheAccountEmailToTheOneWeSubmited() {
    	String expectedMail = "user@phptravels.com";
    	String Mail = driver.findElement(By.cssSelector("input[name='email']")).getText();
    	Assert.assertEquals(expectedMail,Mail);
    	
    }
    
   }