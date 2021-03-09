package maksim_klimenko1.utils;

import maksim_klimenko1.reporting.CustomLogger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilMethods {
   static String SCREENSHOTS_NAME = "FailureScreen";

    public static void setDriverExplicitWait(WebDriver driver, long timeOut, String locator) {
        new WebDriverWait(driver, timeOut).until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    public static void openUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    public static void quitBrowser(WebDriver driver) {
        driver.quit();
    }

    public static void closeBrowser(WebDriver driver) {
        driver.close();
    }


    public static void setDriverImplicitlyWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void type(WebDriver driver, String locator, String text) {
        WebElement element = driver.findElement(By.xpath(locator));
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
        element.sendKeys(text);

    }

     public static void click(WebDriver driver, String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        element.click();

    }

    public static void clickJS(WebDriver driver, String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
    }

    public static void highlightElement(WebDriver driver, String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');", element);
    }

    public static void unhighlightElement(WebDriver driver, String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style','background: white; border: 2px solid white;');", element);
    }

    public static void scrollIntoViewJS(WebDriver driver, String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void takeScreenshot(WebDriver driver) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String screenshotName = SCREENSHOTS_NAME + System.nanoTime();
            String scrPath = screenshotName + ".jpg";
            File copy = new File(scrPath);
            FileUtils.copyFile(screenshot, copy);
            CustomLogger.attach(scrPath, screenshotName);
            CustomLogger.info("Saved screenshot: " + screenshotName);
        } catch (IOException e) {
            CustomLogger.error("Failed to make screenshot");
        }
    }


    public static void clickIgnoreIntrrupt(WebDriver driver, String locator, long timeOut) {
        boolean flag = true;
        while (flag)
            try {
                click(driver,locator);
                flag = false;
            } catch (ElementClickInterceptedException e) {
                new WebDriverWait(driver, timeOut).until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
            }
    }

    public static void swichToFrame(WebDriver driver, String locator) {
        driver.switchTo().frame(driver.findElement(By.xpath(locator)));
    }

    public static void swichToDefaultFrame(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public static String getTextWithRegexp(WebDriver driver, String locator, String regexp) {
        String tempValue = driver.findElement(By.xpath(locator)).getText();
        Pattern p = Pattern.compile(regexp);
        Matcher matcher = p.matcher(tempValue);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    public static void createNewTab(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.open();");
    }

    public static void switchToTab(WebDriver driver, int tabNum) {
        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(tabNum));
    }

    public static String getValueFromElement(WebDriver driver, String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        return element.getAttribute("value");
    }

    public static void verifyElementDisplayed(WebDriver driver, String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        Assert.assertTrue(element.isDisplayed());
    }

    public static void scrollToElemett(WebDriver driver, String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        element.sendKeys(Keys.PAGE_DOWN);
    }
}
