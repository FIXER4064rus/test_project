package maksim_klimenko1.pages;
import maksim_klimenko1.buisnessObjectsAndStaticFactory.EmailObject;
import maksim_klimenko1.buisnessObjectsAndStaticFactory.EmailObjectFactory;
import maksim_klimenko1.utils.UtilMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcPage extends BasePage {

    private final String SEARCH_PATTERN_FOR_COST = "\\d+([,.][0-9]{1,3}([,.][0-9]{1,3}))";
    private final String EMAIL_URL = "https://10minutemail.com/";
    private final String NUM_OF_INST = "9";

    @FindBy(xpath = "//*[@id=\"myFrame\"]")
    private WebElement calcFrameLocator;

    @FindBy(xpath = "//*[@id=\"input_54\"]")
    private WebElement numOfInstancesLocator;

    @FindBy(xpath = "//*[@ng-model=\"listingCtrl.computeServer.instance\"]")
    private WebElement machineTypeDropdownLocator;

    @FindBy(xpath = "//*[@id=\"select_option_350\"]/div[1]")
    private WebElement machineTypeValueLocator;

    @FindBy(xpath = "//*[@id=\"select_value_label_49\"]")
    private WebElement machineFamilyDropdownLocator;

    @FindBy(xpath = "//*[@id=\"select_option_73\"]/div[1]")
    private WebElement machineFamilyValueLocator;

    @FindBy(xpath = "//md-checkbox[contains (.,'Add GPUs')]")
    private WebElement enableGPULocator;

    @FindBy(xpath = "//*[@ng-model=\"listingCtrl.computeServer.gpuCount\"]")
    private WebElement numOfGpuDropdownLocator;

    @FindBy(xpath = "//*[contains(@ng-repeat,\"supportedGpuNumbers\") and contains (@value,'1') ]")
    private WebElement numOfGpuValueLocator;

    @FindBy(xpath = "//*[@ng-model=\"listingCtrl.computeServer.gpuType\"]")
    private WebElement gpuTypeDropdownLocator;

    @FindBy(xpath = "//*[contains(@ng-repeat,\"gpuList\") and contains (@value,'NVIDIA_TESLA_V100') ]")
    private WebElement gpuTypeValueLocator;

    @FindBy(xpath = "//*[@ng-model=\"listingCtrl.computeServer.ssd\"]")
    private WebElement ssdDropdownLocator;

    @FindBy(xpath = "//*[@id=\"select_option_231\"]/div[1]")
    private WebElement ssdValueLocator;

    @FindBy(xpath = "//*[@ng-model=\"listingCtrl.computeServer.location\"]")
    private WebElement locationDropdownLocator;

    @FindBy(xpath = "//*[@id=\"select_option_185\"]")
    private WebElement locationValueLocator;

    @FindBy(xpath = "//*[@ng-model=\"listingCtrl.computeServer.cud\"]")
    private WebElement usageDropdownLocator;

    @FindBy(xpath = "//*[@id=\"select_option_84\"]")
    private WebElement usageValueLocator;

    @FindBy(xpath = "//*[contains (@ng-click,'addComputeServer')]")
    private WebElement addComputeServerLocator;

    @FindBy(xpath = "//*[@id=\"resultBlock\"]/md-card/md-card-content/div/div/div/h2/b")
    private WebElement costLocator;

    @FindBy(xpath = "//*[@aria-label=\"Email Estimate\"]")
    private WebElement emailEstimateLocator;

    @FindBy(xpath = "//*[@ng-model=\"emailQuote.user.email\"]")
    private WebElement userEmailLocator;

    @FindBy(xpath = "//*[@ng-disabled=\"emailForm.$invalid\" and @aria-label=\"Send Email\"]")
    private WebElement clickSendEmailLocator;

    @FindBy(xpath = "//*[@id=\"compute\"]/*/*/*/button[@aria-label=\"edit\"]")
    private WebElement clickEditLocator;

    @FindBy(xpath = "//*[@ng-model=\"emailQuote.user.firstname\"]")
    private WebElement firstNameLocator;

    @FindBy(xpath = "//*[@ng-model=\"emailQuote.user.lastname\"]")
    private WebElement lastNameLocator;

    @FindBy(xpath = "//*[@ng-model=\"appCtrl.CartData.projectName\"]")
    private WebElement companyNameLocator;

    @FindBy(xpath = "//input[@placeholder=\"Search for a product you are interested in.\"]")
    private WebElement searchLoactor;

    @FindBy(xpath = "//*[@id=\"ul-0\"]/li")
    private WebElement searchResult;



    public CalcPage(WebDriver driver) {
        super(driver);
    }

    public void switchToCalcFrame() throws InterruptedException {
        waitSec(5);
        driver.switchTo().frame(calcFrameLocator);
    }


    public void setEmail(String email) throws InterruptedException {
        waitSec(1);
        userEmailLocator.sendKeys(email);
        EmailObject emailObject = EmailObjectFactory.createWithCustomCompany("SomePieceOfCompany");
        firstNameLocator.sendKeys(emailObject.getFirstName());
        lastNameLocator.sendKeys(emailObject.getLastName());
        companyNameLocator.sendKeys(emailObject.getCompanyName());
        waitSec(10);
    }

    public void setClickSendEmail() {
        clickSendEmailLocator.click();
    }


    public void switchToEmailPageAndOpen() {
        UtilMethods.switchToTab(driver, 1);
        driver.get(EMAIL_URL);

    }

    public void goToEmailPage() {
        UtilMethods.switchToTab(driver, 1);
    }

    public void createNewTab() {
        UtilMethods.createNewTab(driver);
    }

    public void clickAddCompute() throws InterruptedException {
        new WebDriverWait(driver, TIME_OUT).until(ExpectedConditions.elementToBeClickable(addComputeServerLocator));
        waitSec(1);
        addComputeServerLocator.click();
    }

    public String getCost() {
        new WebDriverWait(driver, TIME_OUT).until(ExpectedConditions.elementToBeClickable(costLocator));
        String tempValue = costLocator.getText();
        Pattern p = Pattern.compile(SEARCH_PATTERN_FOR_COST);
        Matcher matcher = p.matcher(tempValue);
        if (matcher.find()) {
            return matcher.group();

        }
        return null;
    }

    public void clickEmailEstimate() throws InterruptedException {
        new WebDriverWait(driver, TIME_OUT).until(ExpectedConditions.elementToBeClickable(emailEstimateLocator));
        waitSec(2);
        emailEstimateLocator.click();
        new WebDriverWait(driver, TIME_OUT).until(ExpectedConditions.elementToBeClickable(userEmailLocator));
    }


    public void typeSearch(String search) {
        searchLoactor.sendKeys(Keys.CONTROL + "a");
        searchLoactor.sendKeys(Keys.DELETE);
        searchLoactor.sendKeys(search);
        searchResult.click();

    }

    public void checkResult(String result) {
        UtilMethods.verifyElementDisplayed(driver, "//*[@class=\"md-title\" and contains (.,'" + result + "')]");
    }



    public void typeNumOfInst() {
        numOfInstancesLocator.sendKeys(Keys.CONTROL + "a");
        numOfInstancesLocator.sendKeys(Keys.DELETE);
        numOfInstancesLocator.sendKeys(NUM_OF_INST);
    }

    public void selectMachineType() throws InterruptedException {
        machineTypeDropdownLocator.click();
        waitSec(2);
        machineTypeValueLocator.click();
    }

    public void selectMachineFamily() throws InterruptedException {
        machineFamilyDropdownLocator.click();
        waitSec(2);
        machineFamilyValueLocator.click();
    }

    public void enableGPU() {
        enableGPULocator.click();
    }

    public void selectNumOfGPU() throws InterruptedException {
        numOfGpuDropdownLocator.click();
        waitSec(2);
        numOfGpuValueLocator.click();
    }

    public void selectTypeOfGPU() throws InterruptedException {
        gpuTypeDropdownLocator.click();
        waitSec(2);
        gpuTypeValueLocator.click();

    }

    public void selectSsd() throws InterruptedException {
        waitSec(1);
        ssdDropdownLocator.click();
        waitSec(2);
        ssdValueLocator.click();

    }

    public void selectLocation() throws InterruptedException {
        waitSec(1);
        locationDropdownLocator.click();
        waitSec(2);
        locationValueLocator.click();

    }

    public void selectUsage() throws InterruptedException {
        usageDropdownLocator.click();
        waitSec(2);
        usageValueLocator.click();

    }

    public void clickEdit() {
        clickEditLocator.click();
    }

    public void changeNumOfInst() {
        numOfInstancesLocator.sendKeys(Keys.CONTROL + "a");
        numOfInstancesLocator.sendKeys(Keys.DELETE);
        numOfInstancesLocator.sendKeys(NUM_OF_INST + 2);
    }

    public void checkCostDifferences(String costBefore, String costAfter) {
        Assert.assertNotEquals(costBefore, costAfter);
    }
}
