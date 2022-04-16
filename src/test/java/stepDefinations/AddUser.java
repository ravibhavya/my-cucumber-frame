package stepDefinations;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddUser {
	WebDriver driver;
	String url="http://orangehrm.qedgetech.com/";
	@Given("^we launch url in a browser$")
	public void we_launch_url_in_a_browser() throws Throwable{
		driver= new FirefoxDriver ();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^we enter username and password$")
	public void we_enter_username_and_password() throws Throwable {
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("Qedge123!@#");
	}

	@When("^we click login button$")
	public void we_click_login_button() throws Throwable {
		driver.findElement(By.name("Submit")).click();
	    Thread.sleep(2000);  
	}

	@When("^we click on admin tab$")
	public void we_click_on_admin_tab() throws Throwable {
		driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();  
	}

	@When("^we  click on users tab$")
	public void we_click_on_users_tab() throws Throwable {
		Actions ac=new Actions(driver);
		ac.moveToElement(driver.findElement(By.id("menu_admin_UserManagement"))).perform();
		ac.moveToElement(driver.findElement(By.xpath("//a[@id='menu_admin_viewSystemUsers']"))).click().perform(); 
	}

	@When("^we click on add button$")
	public void we_click_on_add_button() throws Throwable {
		driver.findElement(By.id("btnAdd")).click();
	}

	@When("^we select userrole$")
	public void we_select_userrole() throws Throwable {
		By userrole=By.name("systemUser[userType]");
		Select select1=new Select(driver.findElement(userrole));
		select1.selectByVisibleText("ESS");
	}

	@When("^we enter empname$")
	public void we_enter_empname() throws Throwable {
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("ABCD EFGH");
		
	}

	@When("^we enter username in username feild$")
	public void we_enter_username_in_username_feild() throws Throwable {
		
		driver.findElement(By.name("systemUser[userName]")).sendKeys("Devi26");
	}

	@When("^we select status$")
	public void we_select_status() throws Throwable {
		By status=By.name("systemUser[status]");
		Select select2=new Select(driver.findElement(status));
		select2.selectByVisibleText("Enabled");
		 
	}

	@When("^we enter password in password feild$")
	public void we_enter_password_in_password_feild() throws Throwable {
		driver.findElement(By.name("systemUser[password]")).sendKeys("bhavya@123$");
	}

	@When("^we enter cpassword in password feild$")
	public void we_enter_cpassword_in_password_feild() throws Throwable {
		driver.findElement(By.name("systemUser[confirmPassword]")).sendKeys("bhavya@123$");
	}

	@When("^we click save button$")
	public void we_click_save_button() throws Throwable {
		driver.findElement(By.name("btnSave")).click();; 
	}

	@Then("^we verify with url text$")
	public void we_verify_with_url_text() throws Throwable {
		String expected="viewSystemUsers";
		String actual=driver.getCurrentUrl();
		if(actual.contains(expected)){
			System.out.println("User Added ");
		}
		else{
			System.out.println("User not Added ");
		}
	}
	

	@Then("^we closes the browser$")
	public void we_closes_the_browser() throws Throwable {
	   driver.close();
	}


}
