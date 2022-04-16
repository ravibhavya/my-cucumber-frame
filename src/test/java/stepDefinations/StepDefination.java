package stepDefinations;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefination {
	WebDriver driver;
	String url="http://orangehrm.qedgetech.com/";
	@Given("^User launch url\"([^\"]*)\"in browsers$")
	public void user_launch_url_in_browsers(String brw) throws Throwable {
		if(brw.equalsIgnoreCase("chrome")){
			driver= new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else if(brw.equalsIgnoreCase("firefox")){
			driver= new FirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		}
		else{
			System.out.println("Browser not matching");
		}
	    
	}

	@When("^user enter\"([^\"]*)\"in user feild$")
	public void user_enter_in_user_feild(String username) throws Throwable {
		driver.findElement(By.name("txtUsername")).sendKeys(username);
	  
	}

	@When("^user enter \"([^\"]*)\"in pass feild$")
	public void user_enter_in_pass_feild(String password) throws Throwable {
		driver.findElement(By.name("txtPassword")).sendKeys(password);
	 
	}

	@When("^user clicks Loginbutton$")
	public void user_clicks_Loginbutton() throws Throwable {
		driver.findElement(By.name("Submit")).click();
	    Thread.sleep(2000);
	}

	@Then("^user should verify url text$")
	public void user_should_verify_url_text() throws Throwable {
		String expected="dashboard";
		String actual=driver.getCurrentUrl();
		if(actual.contains(expected)){
			System.out.println("login success");
		}
		else{
			System.out.println("login fails");
			
		}
	   
	}

	@Then("^user closes the browser$")
	public void user_closes_the_browser() throws Throwable {
		driver.close();
	   
	}

}
