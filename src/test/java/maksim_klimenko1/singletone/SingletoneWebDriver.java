package maksim_klimenko1.singletone;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletoneWebDriver {

    private static WebDriver driver;

    private SingletoneWebDriver() {
    }

    public static WebDriver getWebDriverInst() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }
}
