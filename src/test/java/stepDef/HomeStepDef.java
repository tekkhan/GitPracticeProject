package stepDef;

import org.junit.Assert;


import core.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePageObject;

public class HomeStepDef extends Base {
	HomePageObject homePage = new HomePageObject();

	
	@Given("User is on retail Website")
	public void user_is_on_retail_website() throws InterruptedException {
		Assert.assertTrue(homePage.isTestEnvironmentLogoPresent());
		logger.info("user is on Retail Website");
Thread.sleep(3000);

	} 

	@When("User click on myAccount")
	public void user_click_on_myAccount() throws InterruptedException {
		homePage.clickOnMyAccount();
		logger.info("user clicked on MyAccount option");
Thread.sleep(3000);

	}

	@And("User click on Login option")
	public void user_click_on_login_option() throws InterruptedException {
		homePage.clickonLoginOption();
		logger.info("user clicked on Login Option");
Thread.sleep(3000);
	}

	@And("User enter userName {string} and password {string}")
	public void user_enter_userName_and_password(String email, String pass) throws InterruptedException {
		homePage.enterUserNameAndPassword(email, pass);
		logger.info("user enter " + email + " and " + pass);

      Thread.sleep(3000);
	}

	@And("User click on login button")
	public void user_click_on_login_button() throws InterruptedException {
		homePage.clickOnLoginButton();
		logger.info("user clicked on login button");
     Thread.sleep(3000);

	}

	
	
	@Then("User should be logged into myAccount page")
	public void user_should_be_logged_into_myAccount_page() throws InterruptedException {
		Assert.assertTrue(homePage.ismyAccountValidationPresent());
		logger.info("user is on My Account Page");
       Thread.sleep(3000);
	}}


	

