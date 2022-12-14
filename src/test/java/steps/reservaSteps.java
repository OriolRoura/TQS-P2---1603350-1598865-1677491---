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


public class reservaSteps {
	private String roomt;
    private String hotelt;

	WebDriver driver;
	JavascriptExecutor executor;
	
    @Given("the user log in")
    public void theUserLogIn(){
    	System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
    	executor = (JavascriptExecutor)driver;
    	driver = new ChromeDriver();
    	driver.get("https://phptravels.net/login");
    	driver.manage().window().setSize(new org.openqa.selenium.Dimension(1500, 1000));
    	String email = "agent@phptravels.com";
    	String password = "demoagent";
    	driver.findElement(By.cssSelector("input[name='email']")).sendKeys(email);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[4]/div/div[2]/div[2]/div/form/div[3]/button")).click();
    }
    
    @And("the user is in the hotel selection")
    public void theUserIsInTheHotelSelection() {
    	driver.get("https://phptravels.net/hotels");
    }
    
    @When("^the users selects the (.*)")
    public void theUsersSelectsTheHotelSquare(String Hotel) {
    	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
    	String titol = (Hotel + "/div[2]/h6/a/strong");
    	hotelt = driver.findElement(By.xpath(titol)).getText();
    	driver.findElement(By.xpath(Hotel+"/div[1]/a")).sendKeys(Keys.RETURN);
    	
    }
    
    
    @And("^the user chose the (.*)")
    public void theUserchoseTheRoom(String room) {
    	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
    	String titol = (room + "/div[1]/strong");
    	roomt = driver.findElement(By.xpath(titol)).getText();
    	driver.findElement(By.xpath(room + "/div[2]/div/div[2]/form/div/div[5]/div/button")).sendKeys(Keys.RETURN);
    }
    
    @Then("we validate we are in the correct Hotel and the correct Room")
    public void weValidateWeAreInTheCorrectHotelAndTheCorrectRoom() throws InterruptedException {
    	TimeUnit.SECONDS.sleep(1);
    	String hotel = driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div/h3")).getText();
    	String room = driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[2]/div/div[2]/div/div[2]/p")).getText();
    																		
    	Assert.assertTrue(hotelt.contains(hotel));
    	Assert.assertTrue(room.contains(roomt));
    }
    
    @When("adds the hotel Travellers Information")
    public void addsTheHotelTravellersInformation() {
    	driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/div/div[2]/input")).sendKeys("aaa");
    	driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/div/div[3]/input")).sendKeys("aaa");
        
    }
    @And("adds the personal information")
    public void addsThePersonalInformation(){

    }
    
    @And("chooses the payment method")
    public void choosesThePaymentMethod() {
    	
    	
    }
    
    @And("clicks the confirmation button")
    public void clicksTheConfirmationButton() {
    	executor = (JavascriptExecutor)driver;
    	executor.executeScript("arguments[0].click()",driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[4]/div/div/div/label")));
    	driver.findElement(By.id("booking")).sendKeys(Keys.RETURN);
    
    }
    
    @Then("I validate the booking info")
    public void iValidateTheBookingInfo() throws InterruptedException {
    	TimeUnit.SECONDS.sleep(1);
    	String room = driver.findElement(By.xpath("//*[@id=\"fadein\"]/section[1]/div/div/div/div/div[3]/div[3]/div[1]/div[2]/div/ul/li[1]")).getText();
    	Assert.assertTrue(room.contains(roomt));
    	String hotel = driver.findElement(By.xpath("//*[@id=\"fadein\"]/section[1]/div/div/div/div/div[3]/div[3]/div[1]/div[1]/div/div[2]/div/h5")).getText();
    	Assert.assertTrue(hotel.contains(hotelt));
    }
}
