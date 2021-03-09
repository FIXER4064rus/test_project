package maksim_klimenko1.factoryMethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverCreator implements WebDriverCreator {
    public WebDriver createWebDriver() {
        return new FirefoxDriver();
    }
}
