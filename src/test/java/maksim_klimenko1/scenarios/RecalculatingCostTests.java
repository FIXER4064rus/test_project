package maksim_klimenko1.scenarios;

import maksim_klimenko1.factoryMethod.ChromeDriverCreator;
import maksim_klimenko1.factoryMethod.WebDriverCreator;
import maksim_klimenko1.pages.CalcPage;
import maksim_klimenko1.pages.PricingPage;
import maksim_klimenko1.pages.ProductsPage;
import maksim_klimenko1.pages.StartPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RecalculatingCostTests {
    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void driverSetUp() {
        WebDriverCreator creator = new ChromeDriverCreator();
        driver = creator.createWebDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void shutDown() {
        driver.quit();
    }


    @Test
    public void testRecalculatingCost() throws InterruptedException {
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
        String costBefore = calcPage.getCost();
        calcPage.clickEdit();
        calcPage.changeNumOfInst();
        calcPage.clickAddCompute();
        String costAfter = calcPage.getCost();
        calcPage.checkCostDifferences(costBefore, costAfter);

    }

}
