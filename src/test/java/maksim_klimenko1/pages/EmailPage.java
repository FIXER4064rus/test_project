package maksim_klimenko1.pages;

import maksim_klimenko1.utils.UtilMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class EmailPage extends BasePage {

    @FindBy(xpath = "//input[@id=\"mailAddress\"]")
    private WebElement emailLocator;

    @FindBy(xpath = "//*[@id=\"ui-id-1\"]")
    private WebElement receivedEmailLocator;


    public EmailPage(WebDriver driver) {
        super(driver);
    }

    public String getEmailFromPage() {
        return emailLocator.getAttribute("value");
    }

    public void openReceivedMail() {
        receivedEmailLocator.click();
    }

    public void checkCostValue(String cost) {
        UtilMethods.setDriverExplicitWait(driver,TIME_OUT, "//h2[contains(.,'" + cost + "')]");
        UtilMethods.scrollIntoViewJS(driver,"//h2[contains(.,'" + cost + "')]");
        UtilMethods.highlightElement(driver,"//h2[contains(.,'" + cost + "')]");
        UtilMethods.verifyElementDisplayed(driver,"//h2[contains(.,'" + cost + "')]");
    }

    public void scrollDownToElem() {
        new WebDriverWait(driver, TIME_OUT).until(ExpectedConditions.elementToBeClickable(receivedEmailLocator));
        UtilMethods.scrollIntoViewJS(driver,"//*[@id=\"ui-id-1\"]");
    }

    public void goBackToCalcPage() {
        UtilMethods.switchToTab(driver,0);

    }
}
