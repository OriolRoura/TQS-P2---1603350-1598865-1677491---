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


public class mouresAndLogoutSteps {

	WebDriver driver;
	
 @Given("çthe user is in the logIn page")
    public void çtheUserIsInTheIndexPage() {
    	System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.get("https://phptravels.net/");
    	driver.manage().window().maximize();
    }
 
 @When("çthe user clikcs the ACCOUNT button")
    public void çtheUserClicksTheAccountButton() throws InterruptedException {
	 	TimeUnit.SECONDS.sleep(1);
    	driver.findElement(By.id("ACCOUNT")).click();
    }

 @And("^çclicks the Customer Login button (.*)(.*)")
    public void çtheUserClicksTheLoginButton(String Type) {
    	driver.findElement(By.partialLinkText(Type)).click();
    }
 @And("^ç2the user Logs in (.*),(.*)")
 public void çthe_user_logs_in_agent_phptravels_com_demoagent(String Email, String Password) throws InterruptedException{
	 TimeUnit.SECONDS.sleep(1);
	 for (String window : driver.getWindowHandles()) {
			driver.switchTo().window(window);
		}
	 driver.findElement(By.cssSelector("input[name='email']")).sendKeys(Email);
     driver.findElement(By.cssSelector("input[name='password']")).sendKeys(Password);
     driver.findElement(By.cssSelector("button[type='submit']")).click();
     String expectedUrl= driver.getCurrentUrl();
     String actualUrl="https://phptravels.net/account/dashboard";
     //Assert.assertTrue(expectedUrl.equals(actualUrl));
 }	

 @And("çthe user click different parts of webpage")
    public void çtheUserClicksTheMyProfileButton() {
    	driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[4]/div/div[3]/ul/li[2]")).click();    
    	driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[4]/div/div[3]/ul/li[4]")).click(); 
    	driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[4]/div/div[3]/ul/li[3]")).click();    	

    }
 
 @And("çthe user Logout")
 	public void çthe_user_Logout() {
	 	driver.findElement(By.id("currency")).click();
	 	driver.findElement(By.xpath("//*[@id=\"fadein\"]/header/div/div/div/div/div/div[2]/div/div[2]/div[3]/div/ul/li[5]"));
	 	String current = driver.getCurrentUrl();
	 	Assert.assertEquals("https://phptravels.net/login", current);
 	}
}
