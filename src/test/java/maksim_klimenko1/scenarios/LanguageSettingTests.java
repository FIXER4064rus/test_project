package maksim_klimenko1.scenarios;

import maksim_klimenko1.decorator.CustomDriverDecorator;
import maksim_klimenko1.factoryMethod.ChromeDriverCreator;
import maksim_klimenko1.factoryMethod.WebDriverCreator;
import maksim_klimenko1.pages.StartPage;
//import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//@Listeners({ReportPortalTestNGListener.class})
public class LanguageSettingTests {
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
    public void testLanguageSetting() {
        StartPage startPage = new StartPage(driver);
        startPage.openPage();
        startPage.maximizeWindow();
        startPage.verifyLanguageENG();
        startPage.selectLanguageGER();
        startPage.verifyLanguageGER();
    }


}