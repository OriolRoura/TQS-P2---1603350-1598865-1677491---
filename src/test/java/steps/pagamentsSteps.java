package steps;

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

public class pagamentsSteps {
	
	WebDriver driver;
	JavascriptExecutor executor;
	
	@Given("page is started")
	public void thePageIsStarted() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
    	executor = (JavascriptExecutor)driver;
    	driver = new ChromeDriver();
	}
	
	@And("the user is in the hotel payment page")
	public void theUserIsInTheHotelPaymentPage(){
		driver.get("https://phptravels.net/hotels");
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/section[2]/div/div/div[2]/div/div/div/div[1]/div/div[7]/div/div[2]/h6/a")).sendKeys(Keys.RETURN);
		driver.findElement(By.xpath("//*[@id=\"availability\"]/div[2]/div/div[2]/div/div[2]/form/div/div[5]/div/button")).sendKeys(Keys.RETURN);
    }
    
	
	@When("adds the hotel Travellers Information")
	public void addsTheHotelTravellersInformation() {
	    	driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/div/div[2]/input")).sendKeys("aaa");
	    	driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/div/div[3]/input")).sendKeys("aaa");
	        
    }
    @And("^adds the personal (.*),(.*),(.*),(.*),(.*)")
    public void addsThePersonalInformation(String name,String lastname,String email,String phone,String adress){
    	driver.findElement(By.name("firstname")).sendKeys(name);
    	driver.findElement(By.name("lastname")).sendKeys(lastname);
    	driver.findElement(By.name("email")).sendKeys(email);
    	driver.findElement(By.name("phone")).sendKeys(phone);
    	driver.findElement(By.name("address")).sendKeys(adress);
    	
    }
    
    @And("^chooses the payment (.*)")
    public void choosesThePaymentMethod(String method) {
    	JavascriptExecutor executor;
    	executor = (JavascriptExecutor)driver;
    	executor.executeScript(method,driver.findElement(By.xpath("//*[@id=\"myTab\"]/label/label/label/label/label")));
    	
    }
    
    @And("clicks the confirmation button")
    public void clicksTheConfirmationButton() {
    	executor = (JavascriptExecutor)driver;
    	executor.executeScript("arguments[0].click()",driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[4]/div/div/div/label")));
    	driver.findElement(By.id("booking")).sendKeys(Keys.RETURN);
    
    }
    
    @Then("^I validate the general info (.*),(.*),(.*),(.*),(.*),(.*)")
    public void iValidateTheBookingInfo(String name,String lastname,String email,String phone,String adress, String payment) throws InterruptedException {
    	TimeUnit.SECONDS.sleep(1);
    	String var = driver.findElement(By.xpath("//*[@id=\"fadein\"]/section[1]/div/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/ul/li[1]")).getText();
    	Assert.assertTrue(var.contains(name));
    	var = driver.findElement(By.xpath("//*[@id=\"fadein\"]/section[1]/div/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/ul/li[2]")).getText();
    	Assert.assertTrue(var.contains(lastname));
    	var = driver.findElement(By.xpath("//*[@id=\"fadein\"]/section[1]/div/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/ul/li[3]")).getText();
    	Assert.assertTrue(var.contains(email));
    	var = driver.findElement(By.xpath("//*[@id=\"fadein\"]/section[1]/div/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/ul/li[4]")).getText();
    	Assert.assertTrue(var.contains(phone));
    	var = driver.findElement(By.xpath("//*[@id=\"fadein\"]/section[1]/div/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/ul/li[5]")).getText();
    	Assert.assertTrue(var.contains(adress));
    	var = driver.findElement(By.xpath("//*[@id=\"fadein\"]/section[1]/div/div/div/div/div[1]/strong[2]")).getText();
    	Assert.assertTrue(var.contains(payment));
    	
    	    	
    }
    @And("the user is in the flight payment page")
    public void theUserIsInTheFlightPaymentPage(){
    	driver.get("https://phptravels.net/flights"); 
    	driver.findElement(By.xpath("//*[@id=\"new-york\"]/div/div[2]/a")).sendKeys(Keys.RETURN);
    	driver.findElement(By.xpath("//*[@id=\"data\"]/ul/li[1]/div/form/div/div[2]/div/button")).sendKeys(Keys.RETURN);
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
	@And("the user is in the tour payment page")
	public void theUserIsInTheTourPaymentPage(){
		driver.get("https://phptravels.net/tours");    
		driver.findElement(By.xpath(" //*[@id=\"fadein\"]/section[2]/div/div/div[2]/div[1]/div/div[1]/a[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/section[2]/div[2]/div/div/div[2]/div/div/div/form/div[3]/button")).sendKeys(Keys.RETURN);
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
    	//Assert.assertTrue(price.contains(subGrup));
	}
}