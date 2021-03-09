package maksim_klimenko1.scenarios;

import maksim_klimenko1.decorator.CustomDriverDecorator;
import maksim_klimenko1.factoryMethod.ChromeDriverCreator;
import maksim_klimenko1.factoryMethod.WebDriverCreator;
import maksim_klimenko1.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmailPriceTests {
    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void driverSetUp() {
        WebDriverCreator creator = new ChromeDriverCreator();
        driver = creator.createWebDriver();
        driver = new CustomDriverDecorator(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void shutDown() {
        driver.quit();
    }

    @Test
    public void testEmailPrice() throws InterruptedException {
        StartPage startPage = new StartPage(driver);
        startPage.openPage();
        startPage.setImplicitlyWait();
        startPage.goToProductsPage();
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.goToPricingPage();
        PricingPage pricingPage = new PricingPage(driver);
        pricingPage.clickDropdown();
        pricingPage.goToCalcPage();
        CalcPage calcPage = new CalcPage(driver);
        calcPage.switchToCalcFrame();
        calcPage.maximizeWindow();
        calcPage.typeNumOfInst();
        calcPage.selectMachineFamily();
        calcPage.selectMachineType();
        calcPage.enableGPU();
        calcPage.selectNumOfGPU();
        calcPage.selectTypeOfGPU();
        calcPage.selectSsd();
        calcPage.selectLocation();
        calcPage.selectUsage();
        calcPage.clickAddCompute();
        String cost = calcPage.getCost();
        calcPage.clickEmailEstimate();
        calcPage.createNewTab();
        calcPage.switchToEmailPageAndOpen();
        EmailPage emailPage = new EmailPage(driver);
        String mail = emailPage.getEmailFromPage();
        emailPage.goBackToCalcPage();
        CalcPage calcPage1 = new CalcPage(driver);
        calcPage1.switchToCalcFrame();
        calcPage1.setEmail(mail);
        calcPage1.setClickSendEmail();
        calcPage1.goToEmailPage();
        EmailPage emailPage1 = new EmailPage(driver);
        emailPage1.scrollDownToElem();
        emailPage1.openReceivedMail();
        emailPage1.checkCostValue(cost);

    }


}
