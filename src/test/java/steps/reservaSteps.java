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
    
    @When("^the users selects the hotel (.*)")
    public void theUsersSelectsTheHotelSquare(String Hotel) {
    	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
    	String titol = (Hotel + "/div[2]/h6/a/strong");
    	grup = driver.findElement(By.xpath(titol)).getText();
    	driver.findElement(By.xpath(Hotel+"/div[1]/a")).sendKeys(Keys.RETURN);
    	
    }
    
    
    @And("^the user chose the hotel (.*)")
    public void theUserchoseTheRoom(String room) {
    	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
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
    	Assert.assertTrue(room.contains(subGrup));
    	String hotel = driver.findElement(By.xpath("//*[@id=\"fadein\"]/section[1]/div/div/div/div/div[3]/div[3]/div[1]/div[1]/div/div[2]/div/h5")).getText();
    	Assert.assertTrue(hotel.contains(grup));
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
    
	@When("adds the flight Travellers Information")
	public void AddsTheFlightTravellersInformation() {
		executor = (JavascriptExecutor)driver;
		driver.findElement(By.name("lastname_1")).sendKeys("aaa");
    	driver.findElement(By.name("firstname_1")).sendKeys("aaa");
    	driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/div[3]/select/option[3]")).click(); //year
    	driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div/div[2]/div[2]/div[1]/select/option[3]")).click(); //nationality
    	driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/div[1]/select/option[6]")).click(); //month
    	driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/div[2]/select/option[6]")).click(); //day
    		
    	//id
    	
    	driver.findElement(By.name("passport_1")).sendKeys("1133553");	
    	
    	driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div[2]/div/div[1]/select/option[4]")).click(); //month is
    	driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div[3]/div/div[1]/select/option[6]")).click(); //month exp
    	

    }
	@Then("I validate the flight info")
	public void IValidateTheFlightInfo() throws InterruptedException{
		TimeUnit.SECONDS.sleep(1);
		String birth = driver.findElement(By.xpath("//*[@id=\"fadein\"]/section/div/div/div/div/div[3]/div[3]/div[1]/div[2]/div/div[1]/ul/li[3]")).getText(); 
    	String ID = driver.findElement(By.xpath("//*[@id=\"fadein\"]/section/div/div/div/div/div[3]/div[3]/div[1]/div[2]/div/div[2]/ul/li[1]")).getText(); 
    	Assert.assertTrue(birth.contains("06-05-2020"));
    	Assert.assertTrue(ID.contains("1133553"));
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
	
	@When("adds the tour Travellers Information")
	public void addsTheTourTravellersInformation(){
		driver.findElement(By.name("lastname_1")).sendKeys("aaa");
    	driver.findElement(By.name("firstname_1")).sendKeys("aaa");
    	
	}
	
	@Then("I validate the tour info")
	public void IValidateTheTourInfo() throws InterruptedException{
		TimeUnit.SECONDS.sleep(1);
    	String price = driver.findElement(By.xpath("//*[@id=\"fadein\"]/section[1]/div/div/div/div/div[2]/div[2]/form/div/div[4]/strong/h4")).getText();
    	Assert.assertTrue(price.contains(subGrup));
	}
	@And("close")
	public void close() {
		driver.close();
	}
}
