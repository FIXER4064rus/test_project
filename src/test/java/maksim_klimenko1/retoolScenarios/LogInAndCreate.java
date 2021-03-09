package maksim_klimenko1.retoolScenarios;

import maksim_klimenko1.decorator.CustomDriverDecorator;
import maksim_klimenko1.factoryMethod.ChromeDriverCreator;
import maksim_klimenko1.factoryMethod.WebDriverCreator;
import maksim_klimenko1.retoolPages.BusinessesPage;
import maksim_klimenko1.retoolPages.StartPage;
//import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//@Listeners({ReportPortalTestNGListener.class})

public class LogInAndCreate {
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
    public void LogInAndCreate() throws InterruptedException {
        StartPage startPage = new StartPage(driver);
        startPage.openPage();
        startPage.maximizeWindow();
        startPage.goToGoogleLogIn();
        startPage.enterGoogleEmail();
        startPage.enterGooglePass();
        BusinessesPage businessesPage = new BusinessesPage(driver);
        businessesPage.addBusiness();
        businessesPage.typeNameOfBusiness();
        businessesPage.setCategoryOfBusiness();
        businessesPage.typeDesctiptionOfBusiness();
        businessesPage.setAddressOfBusiness();
        businessesPage.submitNewBusiness();
        businessesPage.searchBusiness();
        businessesPage.clickDeleteBusinessButton();
        businessesPage.confirmDeleteBusiness();
    }


}