package maksim_klimenko1.retoolPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected WebDriver driver;

    protected final long TIME_OUT = 60;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void waitSec(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }

}
