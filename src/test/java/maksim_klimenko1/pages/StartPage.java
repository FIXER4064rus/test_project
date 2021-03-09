package maksim_klimenko1.pages;

import maksim_klimenko1.reporting.CustomLogger;
import maksim_klimenko1.utils.UtilMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class StartPage extends BasePage {

    private final String URL = "https://frietech.retool.com/apps/Businesses#";

    private final String WHY_GOOGLE_ENG_LOCATOR = "//*[contains(@class,'devsite-nav-tab') and contains (@data-label,\"Tab: Why Google\")]";
    private final String SOLUTIONS_ENG_LOCATOR = "//*[contains(@class,'devsite-nav-tab') and contains (@data-label,\"Tab: Solutions\")]";
    private final String PRODUCTS_ENG_LOCATOR = "//*[contains(@class,'devsite-nav-tab') and contains (@data-label,\"Tab: Products\")]";
    private final String PRICING_ENG_LOCATOR = "//*[contains(@class,'devsite-nav-tab') and contains (@data-label,\"Tab: Pricing\")]";
    private final String GETTING_STARTED_ENG_LOCATOR = "//*[contains(@class,'devsite-nav-tab') and contains (@data-label,\"Tab: Getting started\")]";

    private final String WHY_GOOGLE_GER_LOCATOR = "//*[contains(@class,'devsite-nav-tab') and contains (@data-label,\"Tab: Vorteile von Google\")]";
    private final String SOLUTIONS_GER_LOCATOR = "//*[contains(@class,'devsite-nav-tab') and contains (@data-label,\"Tab: Lösungen\")]";
    private final String PRODUCTS_GER_LOCATOR = "//*[contains(@class,'devsite-nav-tab') and contains (@data-label,\"Tab: Produkte\")]";
    private final String PRICING_GER_LOCATOR = "//*[contains(@class,'devsite-nav-tab') and contains (@data-label,\"Tab: Preise\")]";
    private final String GETTING_STARTED_GER_LOCATOR = "//*[contains(@class1,'devsite-nav-tab') and contains (@data-label,\"Einstieg\")]";

    @FindBy(xpath = "//*[@track-name=\"seeProducts\"]")
    private WebElement seeProductLocator;

    @FindBy(xpath = "//div[@class=\"devsite-top-logo-row devsite-full-site-width\"]/form/span/div[contains(.,'Language') and @class = 'label' ]")
    private WebElement languageDropDownLocator;

    @FindBy(xpath = "//*[@id=\"top_of_page\"]/ul[1]/li[@value=\"de\"]")
    private WebElement deutschLocator;


    public StartPage(WebDriver driver) {
        super(driver);
    }

    public void setImplicitlyWait() {
        UtilMethods.setDriverImplicitlyWait(driver);
    }


    public void openPage() {
        driver.get(URL);
        CustomLogger.debug("Opened url" + URL);
        CustomLogger.info("New page is opened");
    }


    public void goToProductsPage() {
        seeProductLocator.click();
    }

    public void verifyLanguageENG() {
        try {
            UtilMethods.setDriverExplicitWait(driver, TIME_OUT, WHY_GOOGLE_ENG_LOCATOR);
            CustomLogger.info("Setting time out, max at " + TIME_OUT + " seconds" );
            UtilMethods.highlightElement(driver,WHY_GOOGLE_ENG_LOCATOR);
            UtilMethods.verifyElementDisplayed(driver, WHY_GOOGLE_ENG_LOCATOR);
            waitSec(3);
            CustomLogger.debug("Checking" + WHY_GOOGLE_ENG_LOCATOR);
            UtilMethods.unhighlightElement(driver, WHY_GOOGLE_ENG_LOCATOR);
            UtilMethods.highlightElement(driver,SOLUTIONS_ENG_LOCATOR);
            UtilMethods.verifyElementDisplayed(driver, SOLUTIONS_ENG_LOCATOR);
            CustomLogger.debug("Checking" + SOLUTIONS_ENG_LOCATOR);
            UtilMethods.unhighlightElement(driver, SOLUTIONS_ENG_LOCATOR);
            UtilMethods.highlightElement(driver,PRODUCTS_ENG_LOCATOR);
            UtilMethods.verifyElementDisplayed(driver, PRODUCTS_ENG_LOCATOR);
            CustomLogger.debug("Checking" + PRODUCTS_ENG_LOCATOR);
            UtilMethods.unhighlightElement(driver, PRODUCTS_ENG_LOCATOR);
            UtilMethods.highlightElement(driver,PRICING_ENG_LOCATOR);
            UtilMethods.verifyElementDisplayed(driver, PRICING_ENG_LOCATOR);
            CustomLogger.debug("Checking" + PRICING_ENG_LOCATOR);
            UtilMethods.unhighlightElement(driver, PRICING_ENG_LOCATOR);
            UtilMethods.highlightElement(driver,GETTING_STARTED_ENG_LOCATOR);
            UtilMethods.verifyElementDisplayed(driver, GETTING_STARTED_ENG_LOCATOR);
            CustomLogger.debug("Checking" + GETTING_STARTED_ENG_LOCATOR);
            UtilMethods.unhighlightElement(driver, GETTING_STARTED_ENG_LOCATOR);
            CustomLogger.info("ENG language is checked ");
        } catch (Exception e) {
            CustomLogger.error("Failed at:", e);
            throw new RuntimeException(e);
        }

    }

    public void verifyLanguageGER() {
        try {
            UtilMethods.setDriverExplicitWait(driver, TIME_OUT, WHY_GOOGLE_GER_LOCATOR);
            CustomLogger.info("Setting time out, max at " + TIME_OUT + " seconds");
            UtilMethods.highlightElement(driver,WHY_GOOGLE_GER_LOCATOR);
            UtilMethods.verifyElementDisplayed(driver, WHY_GOOGLE_GER_LOCATOR);
            CustomLogger.debug("Checking" + WHY_GOOGLE_GER_LOCATOR);
            UtilMethods.unhighlightElement(driver, WHY_GOOGLE_GER_LOCATOR);
            UtilMethods.highlightElement(driver,SOLUTIONS_GER_LOCATOR);
            UtilMethods.verifyElementDisplayed(driver, SOLUTIONS_GER_LOCATOR);
            CustomLogger.debug("Checking" + SOLUTIONS_GER_LOCATOR);
            UtilMethods.unhighlightElement(driver, SOLUTIONS_GER_LOCATOR);
            UtilMethods.highlightElement(driver,PRODUCTS_GER_LOCATOR);
            UtilMethods.verifyElementDisplayed(driver, PRODUCTS_GER_LOCATOR);
            CustomLogger.debug("Checking" + PRODUCTS_GER_LOCATOR);
            UtilMethods.unhighlightElement(driver, PRODUCTS_GER_LOCATOR);
            UtilMethods.highlightElement(driver,PRICING_GER_LOCATOR);
            UtilMethods.verifyElementDisplayed(driver, PRICING_GER_LOCATOR);
            CustomLogger.debug("Checking" + PRICING_GER_LOCATOR);
            UtilMethods.unhighlightElement(driver, PRICING_GER_LOCATOR);
            UtilMethods.highlightElement(driver,GETTING_STARTED_GER_LOCATOR);
            UtilMethods.verifyElementDisplayed(driver, GETTING_STARTED_GER_LOCATOR);
            CustomLogger.debug("Checking" + GETTING_STARTED_GER_LOCATOR);
            UtilMethods.unhighlightElement(driver, GETTING_STARTED_GER_LOCATOR);
            CustomLogger.info("GER language is checked ");
        } catch (Exception e) {
            CustomLogger.error("Failed at:", e);
            UtilMethods.takeScreenshot(driver);
            throw new RuntimeException(e);
        }
    }

    public void selectLanguageGER() {
        languageDropDownLocator.click();
        deutschLocator.click();
    }


}
