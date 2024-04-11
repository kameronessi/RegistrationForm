import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		tags = "@regression",
		features = {"classpath:features"},
		glue = {"classpath:stepDefinitions", "classpath:utilities"},
		plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})

public class TestRunner extends AbstractTestNGCucumberTests{

}
