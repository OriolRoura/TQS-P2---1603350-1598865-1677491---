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
	
 @Given("the user is in the logIn page")
    public void theUserIsInTheIndexPage() {
    	System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.get("https://phptravels.net/");
    	driver.manage().window().maximize();
    }
 
 @When("the user clikcs the ACCOUNT button")
    public void theUserClicksTheAccountButton() throws InterruptedException {
	 	TimeUnit.SECONDS.sleep(1);
    	driver.findElement(By.id("ACCOUNT")).click();
    }

 @And("clicks the Customer Login button")
    public void theUserClicksTheLoginButton(String Type) {
    	driver.findElement(By.partialLinkText(Type)).click();
    }
 
 @Then("the user Logs in")
    public void theUserLogIn(String Email, String Password){
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys(Email);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(Password);
        driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[4]/div/div[2]/div[2]/div/form/div[3]/button")).click();
        String expectedUrl= driver.getCurrentUrl();
        String actualUrl="https://phptravels.net/account/dashboard";
        Assert.assertEquals(expectedUrl,actualUrl);
    }
   
 @When("the user clikcs the MyProfile button")
    public void theUserClicksTheMyProfileButton() {
    	driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[4]/div/div[3]/ul/li[4]/a")).click();
    	
    }
    
 @Then("we compare the account email to the one we submited")
    public void WeCompareTheAccountEmailToTheOneWeSubmited() {
    	String expectedUser = "";
    	String User = driver.findElement(By.name("user")).getText();
    	Assert.assertEquals(expectedUser,User);
    	
   }
 @And("close")
	public void close() {
		driver.close();
	}
 
 @Then("the user Logs in wrong")
 public void theUserLogIn(String Email, String Password){
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys(Email);
     driver.findElement(By.cssSelector("input[name='password']")).sendKeys(Password);
     driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[4]/div/div[2]/div[2]/div/form/div[3]/button")).click();
     String expectedUrl= driver.getCurrentUrl();
     String actualUrl="https://phptravels.net/login/failed;
     Assert.assertEquals(expectedUrl,actualUrl);
 	
}
}
