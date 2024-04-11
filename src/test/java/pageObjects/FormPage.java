package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Hooks;

import java.time.Duration;

public class FormPage {
	
	Hooks hook = new Hooks();
	WebDriver driver = hook.getDriver();

    public FormPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "registrationForm")
    private WebElement registrationForm;
	
    @FindBy(id = "name")
    private WebElement fldName;

    @FindBy(id = "phoneNumber")
    private WebElement fldPhone;

    @FindBy(id = "email")
    private WebElement fldEmail;

    @FindBy(id = "userID")
    private WebElement fldUserID;

    @FindBy(id = "password")
    private WebElement fldPassword;

    public boolean verifyOnFormPage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement visibElement = wait.until(ExpectedConditions.visibilityOf(registrationForm));
        return visibElement.isDisplayed();
    }

    public void addValueInTheField(String valueName, String valuePhone, String valueEmail, String valueUserID, String valuePassword){
        fldName.sendKeys(valueName);
        fldPhone.sendKeys(valuePhone);
        fldEmail.sendKeys(valueEmail);
        fldUserID.sendKeys(valueUserID);
        fldPassword.sendKeys(valuePassword);
    }

    public void clicksButton(String button){
        WebElement elementButton = driver.findElement(By.xpath("//button[text()='"+button+"']"));
        elementButton.click();
    }
}
