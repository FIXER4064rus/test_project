package maksim_klimenko1.stepdefs;

import maksim_klimenko1.factoryMethod.ChromeDriverCreator;
import maksim_klimenko1.factoryMethod.WebDriverCreator;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    WebDriver driver;

    @Before
    public void driverSetUp() {
        WebDriverCreator creator = new ChromeDriverCreator();
        driver = creator.createWebDriver();
    }

}
