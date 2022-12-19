package steps;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CompanySteps {

	WebDriver driver;
	
 @Given("the user is in the main page")
    public void theUserIsInTheMainPage() {
    	System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.get("https://phptravels.net/");
    	driver.manage().window().maximize();
    }
 
 @When("the user clikcs the Company button")
    public void theUserClicksTheCompanyButton() throws InterruptedException {
	 	TimeUnit.SECONDS.sleep(1);
    	new Actions(driver).moveToElement(driver.findElement(By.xpath("//*[@id=\"fadein\"]/header/div/div/div/div/div/div[2]/div/div[1]/nav/ul/li[8]"))).perform();
 	}

 @Then("^clicks the Company option button(.*)")
    public void theUserClicksTheCompanyOptionButton(String Type) throws InterruptedException {
	 	String s = Type.strip();
    	driver.findElement(By.partialLinkText(s)).click();
    	TimeUnit.SECONDS.sleep(1);
    	String name= driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[4]/div/div[1]/h3")).getText();
    	Assert.assertTrue(name.contains(s));
    }

	@And("close4")
	public void close() {
		driver.close();
	}
}
