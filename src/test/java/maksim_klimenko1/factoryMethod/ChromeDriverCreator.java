package maksim_klimenko1.factoryMethod;

import maksim_klimenko1.singletone.SingletoneWebDriver;
import org.openqa.selenium.WebDriver;

public class ChromeDriverCreator implements WebDriverCreator {
    public WebDriver createWebDriver(){
        return SingletoneWebDriver.getWebDriverInst();
    }
}
