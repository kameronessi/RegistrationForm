package utilities;

import io.cucumber.java.*;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.URL;

public class Hooks {
	
	private static WebDriver driver;

	@Before
	public void openBrowser(){
         driver = WebDrivers.getDriver();

        URL htmlFileUrl = this.getClass().getClassLoader().getResource("RegistrationForm.html");
        if (htmlFileUrl == null) {
            throw new RuntimeException("Cannot find resource RegistrationForm.html");
        }

        driver.get("file:///" + new File(htmlFileUrl.getFile()).getAbsolutePath());
        driver.manage().window().maximize();
    }
	
	 @AfterStep
	public void addScreenShot(Scenario scenario){
		 if(scenario.isFailed()) {
			 byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			 Allure.addAttachment("Failed Screenshot", new ByteArrayInputStream(screenshot));
		 }
	 }

     @AfterAll
     public static void closeBrowser(){
        driver.quit();
     }
    
    public WebDriver getDriver() {
        return driver;
    }

}
