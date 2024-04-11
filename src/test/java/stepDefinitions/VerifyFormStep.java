package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.FormPage;
import utilities.Hooks;

import java.time.Duration;


public class VerifyFormStep {
	
	Hooks hook = new Hooks();
	WebDriver driver = hook.getDriver();
    FormPage formPage = new FormPage(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	private String alertMessage="";

	@Given("User is on form page")
	public void user_is_on_form_page() {
	    Assert.assertTrue(formPage.verifyOnFormPage());
	}

	@When("User puts values in the fields {string} {string} {string} {string} {string}")
	public void userPutsValuesInTheFields(String fldName, String fldPhone, String fldEmail, String fldUserID, String fldPassword) {
		formPage.addValueInTheField(fldName,fldPhone,fldEmail,fldUserID,fldPassword);
	}

	@And("Clicks on button {string}")
	public void clicksOnButton(String button) {
			formPage.clicksButton(button);
	}

	@Then("expected result is {string} for {string}")
	public void expectedResultIs(String expectedMessage, String fieldID) {

		try {
			Alert alert = driver.switchTo().alert();
			alertMessage = alert.getText();
			alert.accept();
		} catch (NoAlertPresentException ignored) {}

		String validationMessage = (String) js.executeScript("return document.getElementById('"+fieldID+"').validationMessage;");
		new WebDriverWait(driver, Duration.ofSeconds(10)).until((ExpectedCondition<Boolean>) webDriver -> !alertMessage.isEmpty() || !validationMessage.isEmpty());

		boolean conditionsMet = expectedMessage.equals(alertMessage) || expectedMessage.equals(validationMessage);
		Assert.assertTrue(conditionsMet);
	}
}