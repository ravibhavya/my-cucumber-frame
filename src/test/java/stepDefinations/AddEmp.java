package stepDefinations;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddEmp {
	WebDriver driver;
	String url="http://orangehrm.qedgetech.com/";
	@Given("^I launch url in a browser$")
	public void i_launch_url_in_a_browser() throws Throwable {
		
			driver= new FirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}

	@When("^I enter username And password$")
	public void i_enter_username_And_password() throws Throwable {
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("Qedge123!@#");
	}

	@When("^I click login button$")
	public void i_click_login_button() throws Throwable {
		driver.findElement(By.name("Submit")).click();
	    Thread.sleep(2000);
	}

	@When("^I click pim tab$")
	public void i_click_pim_tab() throws Throwable {
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
	}

	@When("^I click add button$")
	public void i_click_add_button() throws Throwable {
		driver.findElement(By.id("btnAdd")).click(); 
	}

	@When("^I enter fname And mname And lname$")
	public void i_enter_fname_And_mname_And_lname() throws Throwable{
		driver.findElement(By.name("firstName")).sendKeys("Testing");
		driver.findElement(By.name("middleName")).sendKeys("Selenium");
		driver.findElement(By.name("lastName")).sendKeys("Manual");
	}

	@When("^I click save button$")
	public void i_click_save_button() throws Throwable {
		driver.findElement(By.id("btnSave")).click();   
	}

	@Then("^I verify url text$")
	public void i_verify_url_text() throws Throwable {
	  String expexted="empNumber" ;
	  String actual=driver.getCurrentUrl();
	  if (actual.contains(expexted)){
		  System.out.println("employe added");
	  }
	  else{
		  System.out.println("employee not added");
	  }
	}

	@Then("^I closes the browser$")
	public void i_closes_the_browser() throws Throwable {
	driver.close();
	}


}
