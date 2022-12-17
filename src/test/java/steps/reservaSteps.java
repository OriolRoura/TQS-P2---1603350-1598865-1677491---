package steps;

import java.time.Duration;
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


public class reservaSteps {
	private String subGrup;
    private String grup;
    private int num;

	WebDriver driver;
	JavascriptExecutor executor;
	
    @Given("the user log in")
    public void theUserLogIn() throws InterruptedException{
    	System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
    	executor = (JavascriptExecutor)driver;
    	driver = new ChromeDriver();
    	driver.get("https://phptravels.net/login");
    	TimeUnit.SECONDS.sleep(1);
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
    
    @When("^the users selects the hotel (.*)")
    public void theUsersSelectsTheHotelSquare(String Hotel) {
    	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
    	String titol = (Hotel + "/div[2]/h6/a/strong");
    	grup = driver.findElement(By.xpath(titol)).getText();
    	driver.findElement(By.xpath(Hotel+"/div[1]/a")).sendKeys(Keys.RETURN);
    	
    }
    
    
    @And("^the user chose the hotel (.*)")
    public void theUserchoseTheRoom(String room) throws InterruptedException {
    	TimeUnit.SECONDS.sleep(1);
    	String titol = (room + "/div[1]/strong");
    	subGrup = driver.findElement(By.xpath(titol)).getText();
    	driver.findElement(By.xpath(room + "/div[2]/div/div[2]/form/div/div[5]/div/button")).sendKeys(Keys.RETURN);
    }
    
    @Then("we validate we are in the correct Hotel and the correct Room")
    public void weValidateWeAreInTheCorrectHotelAndTheCorrectRoom() throws InterruptedException {
    	TimeUnit.SECONDS.sleep(1);
    	String hotel = driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div/h3")).getText();
    	String room = driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[2]/div/div[2]/div/div[2]/p")).getText();
    																		
    	Assert.assertTrue(grup.contains(hotel));
    	Assert.assertTrue(room.contains(subGrup));
    }
    
   
    
    
    
    
    
    
    @And("the user is in the fly selection")
    public void theUserIsInTheFlySelection() {
    	driver.get("https://phptravels.net/flights");    
    }
    
    @When("^the users selects the flight (.*)")
    public void theUsersSelectsTheFlightCompany(String company) {
    	driver.findElement(By.xpath(company)).sendKeys(Keys.RETURN);
    	
    }

    

	@And("^the user chose the flight (.*)")
    public void theUserChoseTheFlightTrip(String trip) {
    	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
    	String partial = (trip + "/div[1]/div[1]/div[2]/div/div/div/div/div[1]/div");
    	subGrup = driver.findElement(By.xpath(partial + "/h5[2]")).getText();
    	grup = driver.findElement(By.xpath(partial + "/h5[1]")).getText();
    	driver.findElement(By.xpath(trip + "/div[2]/div/button")).sendKeys(Keys.RETURN);
    }
    
	@Then("we validate we are in the company flight and the correct flight")
    public void weValidateWeAreInTheCompanyFlightAndCheCorrectFlight() throws InterruptedException {
		TimeUnit.SECONDS.sleep(1);
    	String company = driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/div[2]/strong/div/div/ul/li[1]/span")).getText();
    	String flight = driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/div[2]/strong/div/div/ul/li[2]/span/span	")).getText();
    																		
    	Assert.assertTrue(company.contains(grup));
    	Assert.assertTrue(flight.contains(subGrup));
    }
    
	
	@And("the user is in the tour selection")
	public void theUserIsInTheTourSelection(){
		driver.get("https://phptravels.net/tours");    
	}
	
	@When("^the users selects the tour(.*)")
	public void theUsersSelectsTheTour(String destination){
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
    	String titol = (destination + "/div/div/span");
    	grup = driver.findElement(By.xpath(titol)).getText();
    	driver.findElement(By.xpath(destination)).click();
    	
	}
	
	@And("^the user chose the tour participants (.*), (.*), (.*)")
	public void theUserChoseTheTourParticipants(String adults,String infant, String childs){
		driver.findElement(By.id("adults")).sendKeys(adults);
		driver.findElement(By.id("childs")).sendKeys(infant);
		driver.findElement(By.id("infants")).sendKeys(childs);
		subGrup = driver.findElement(By.xpath("//*[@id=\"fadein\"]/section[2]/div[2]/div/div/div[2]/div/div/div/div/div/p/span/span")).getText();
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/section[2]/div[2]/div/div/div[2]/div/div/div/form/div[3]/button")).sendKeys(Keys.RETURN);
	}
	
	@Then("we validate we are in the tour")
	public void weValidateWeAreInTheTour() throws InterruptedException{
		TimeUnit.SECONDS.sleep(1);
    	String destination = driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div/p")).getText();
    	String price = driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[2]/div/div[2]/div/div[2]/ul[3]/li[3]/strong")).getText();
    																		
    	Assert.assertTrue(destination.contains(grup));
    	Assert.assertTrue(price.contains(subGrup));
	}
	
	
	@And("close")
	public void close() {
		driver.close();
	}
}
