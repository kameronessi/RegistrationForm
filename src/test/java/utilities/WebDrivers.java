package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDrivers {
    public static WebDriver driver;
    static String browserType = ConfigLoader.getProperty("browserType");

    public static WebDriver getDriver() {
        if (driver == null && browserType.equals("chrome")) {
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--remote-allow-origins");
           driver = new ChromeDriver(option);
        }
        if (driver == null && browserType.equals("firefox")) {
            driver = new FirefoxDriver();
        }
        if (driver == null && browserType.equals("edge")) {
            driver = new EdgeDriver();
        }
        return driver;
    }
}
