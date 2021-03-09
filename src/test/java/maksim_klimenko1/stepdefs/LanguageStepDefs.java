package maksim_klimenko1.stepdefs;

import maksim_klimenko1.decorator.CustomDriverDecorator;
import maksim_klimenko1.factoryMethod.ChromeDriverCreator;
import maksim_klimenko1.factoryMethod.WebDriverCreator;
import maksim_klimenko1.pages.StartPage;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebDriver;


public class LanguageStepDefs {
    WebDriver driver;

    @Given("Create new driver")
    public void driverSetUp() {
        WebDriverCreator creator = new ChromeDriverCreator();
        driver = creator.createWebDriver();
        driver = new CustomDriverDecorator(driver);
    }

    @Given("^I opened page$")
    public void iOpenedPage() {
        StartPage startPage = new StartPage(driver);
        startPage.openPage();
        startPage.maximizeWindow();
    }

    @And("^I check ENG language$")
    public void iCheckENGLanguage() {
        StartPage startPage = new StartPage(driver);
        startPage.verifyLanguageENG();
    }

    @When("^I switch language$")
    public void iSwitchLanguage() {
        StartPage startPage = new StartPage(driver);
        startPage.selectLanguageGER();
    }

    @Then("^I check GER language")
    public void iCheckGERLanguage() {
        StartPage startPage = new StartPage(driver);
        startPage.verifyLanguageGER();
    }

    @And("^Shutdown$")
    public void shutdown() {
        driver.quit();
    }
}
