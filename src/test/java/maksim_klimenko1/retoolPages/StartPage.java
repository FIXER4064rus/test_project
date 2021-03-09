package maksim_klimenko1.retoolPages;

import maksim_klimenko1.reporting.CustomLogger;
import maksim_klimenko1.utils.UtilMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class StartPage extends BasePage {

    private final String URL = "https://frietech.retool.com/apps/Businesses#";
    private final String USER_EMAIL = "GoogleLogin";
    private final String USER_PASS = "Googlepassword";

    @FindBy(xpath = "//button [contains (@class,\"ant-btn retool-button google-login-button ant-btn-default ant-btn-block\")]")
    private WebElement signInWithGoogle;
    private final String SIGN_IN_WITH_GOOGLE = "//button [contains (@class,\"ant-btn retool-button google-login-button ant-btn-default ant-btn-block\")]";

    @FindBy(xpath = "//input[@type=\"email\"]")
    private WebElement googleEmail;
    private final String GOOGLE_EMAIL = "//input[@type=\"email\"]";

    @FindBy(xpath = "//input[@type=\"password\"]")
    private WebElement googlePass;
    private final String GOOGLE_PASS = "//input[@type=\"password\"]";

    @FindBy(xpath = "//*[@id=\"identifierNext\"]")
    private WebElement emailNextButton;

    @FindBy(xpath = " //*[@id=\"passwordNext\"]")
    private WebElement passNextButton;


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

    public void goToGoogleLogIn() throws InterruptedException {
        UtilMethods.setDriverExplicitWait(driver, TIME_OUT, SIGN_IN_WITH_GOOGLE);
        signInWithGoogle.click();
    }

    public void enterGoogleEmail() throws InterruptedException {
        UtilMethods.setDriverExplicitWait(driver, TIME_OUT, GOOGLE_EMAIL);
        googleEmail.sendKeys(USER_EMAIL);
        //waitSec(1);
        emailNextButton.click();
        //waitSec(60);
    }

    public void enterGooglePass() throws InterruptedException {
        UtilMethods.setDriverExplicitWait(driver, TIME_OUT, GOOGLE_PASS);
        googlePass.sendKeys(USER_PASS);
        passNextButton.click();
    }


}
