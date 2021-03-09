package maksim_klimenko1.decorator;

import org.openqa.selenium.*;

import java.util.List;
import java.util.Set;

public class CustomDriverDecorator implements WebDriver, JavascriptExecutor, TakesScreenshot {
    protected WebDriver driver;

    public CustomDriverDecorator(WebDriver driver) {
        this.driver = driver;
    }

    public void get(String url) {
        driver.get(url);
        System.out.println("Opening URL");
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public List<WebElement> findElements(By var1) {
        return driver.findElements(var1);
    }

    public WebElement findElement(By var1) {
        return driver.findElement(var1);
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    public void close() {
        System.out.println("Tab shutdown");
        driver.close();
    }

    public void quit() {
        System.out.println("Browser shutdown");
        driver.quit();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    public Navigation navigate() {
        return driver.navigate();
    }

    public Options manage() {
        return driver.manage();
    }

    public Object executeScript(String var1, Object... var2) {
        return ((JavascriptExecutor) driver).executeScript(var1, var2);
    }

    public Object executeAsyncScript(String var1, Object... var2) {
        return ((JavascriptExecutor) driver).executeAsyncScript(var1, var2);
    }

    public <X> X getScreenshotAs (OutputType<X> var1) throws WebDriverException {
        return ((TakesScreenshot)driver).getScreenshotAs(var1);
    }

}
