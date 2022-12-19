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
    	driver.findElement(By.xpath("//*[@id=\"fadein\"]/header/div/div/div/div/div/div[2]/div/div[1]/nav/ul/li[8]/a")).hover();
    }

 @Then("^clicks the Company option button(.*)")
    public void theUserClicksTheCompanyOptionButton(String Type) {
    	driver.findElement(By.partialLinkText(Type)).click();
    	String name= "//*[@id=\"fadein\"]/div[4]/div/div[1]/h3";
    	 Assert.assertTrue(Type.contains(name));
    	
    }
 
	@And("close")
	public void close() {
		driver.close();
	}
}
