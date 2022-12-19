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

 @And("^clicks the Customer Login button (.*)")
    public void theUserClicksTheLoginButton(String Type) {
    	driver.findElement(By.partialLinkText(Type)).click();
    }
 @And("^the user Logs in (.*),(.*)")
 public void the_user_logs_in_agent_phptravels_com_demoagent(String Email, String Password) throws InterruptedException{
	 TimeUnit.SECONDS.sleep(1);
	 for (String window : driver.getWindowHandles()) {
			driver.switchTo().window(window);
		}
	 driver.findElement(By.cssSelector("input[name='email']")).sendKeys(Email);
     driver.findElement(By.cssSelector("input[name='password']")).sendKeys(Password);
     driver.findElement(By.cssSelector("button[type='submit']")).click();
 }	
   
 @And("the user clikcs the MyProfile button")
    public void theUserClicksTheMyProfileButton() {
	 	driver.findElement(By.id("dropdownMenuProfile")).click();
	 	driver.findElement(By.xpath("/html/body/nav/div/div/div/div[3]/ul/li[1]/a")).click();
    	
    }
    
 @Then("^we compare the (.*) email to the one we submited")
    public void WeCompareTheAccountEmailToTheOneWeSubmited(String user) {
    	String expectedUser = user;
    	String User = driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[4]/div/div[2]/div/div[2]/h4/strong")).getText();
    	Assert.assertTrue(expectedUser.contains(User));
    	String expectedUrl= driver.getCurrentUrl();
        String actualUrl="https://phptravels.net/account/dashboard";
    	Assert.assertTrue(expectedUrl.equals(actualUrl));
    	
   }
 @Then("we compare the account email to the one we submited supplier")
 public void WeCompareTheAccountEmailToTheOneWeSubmitedSupplier() {
	driver.findElement(By.xpath("/html/body/nav/div/div/div/div[3]/button/i")).click();
	driver.findElement(By.xpath("/html/body/nav/div/div/div/div[3]/ul/li[1]/a/div")).click();
 	String expectedUser = "Demo";
 	String User = driver.findElement(By.xpath("//*[@id=\"layoutDrawer_content\"]/main/div/form/div/div/div/div/div[3]/div/div/div[2]/div/input")).getText();
 	//Assert.assertTrue(expectedUser.contains(User));
 	String expectedUrl= driver.getCurrentUrl();
    String actualUrl="https://phptravels.net/api/supplier";
	Assert.assertTrue(expectedUrl.equals(actualUrl));
}
 
 @And("close")
	public void close() {
		driver.close();
	}
 
 @Then("^the user Logs in wrong (.*),(.*)")
 public void theUserLogInWrong(String Email, String Password){
	 driver.findElement(By.name("email")).sendKeys(Email);
     driver.findElement(By.name("password")).sendKeys(Password);
     driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[4]/div/div[2]/div[2]/div/form/div[3]/button")).click();
     String expectedUrl= driver.getCurrentUrl();
     String actualUrl="https://phptravels.net/login/failed";
     Assert.assertEquals(expectedUrl,actualUrl);
 	
}
}
