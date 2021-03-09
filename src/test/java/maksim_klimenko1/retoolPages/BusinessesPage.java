package maksim_klimenko1.retoolPages;

import maksim_klimenko1.utils.UtilMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BusinessesPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,\"retool-widget _retool-container-addBusinessButton\")]")
    private WebElement addBusinessLocator;
    private final String ADD_BUSINESS_LOCATOR = "//div[contains(@class,\"retool-widget _retool-container-addBusinessButton\")]";

    @FindBy(xpath = "//input[contains (@placeholder,\"Specify name\")]")
    private WebElement typeNameLocator;
    private final String TYPE_NAME_LOCATOR = "//input[contains (@placeholder,\"Specify name\")]";


    @FindBy(xpath = "//*[contains (.,\"Select a value\") and contains (@class,'ant-select-selection__placeholder') ]")
    private WebElement selectCategoryField;

    @FindBy(xpath = "//li[@label=\"Bar\"]")
    private WebElement selectCategory;
    private final String SELECT_CATEGORY = "//li[@label=\"Bar\"]";


    @FindBy(xpath = "//textarea[contains(@placeholder,\"Specify desctiption\")]")
    private WebElement descreptionLocator;

    @FindBy(xpath = "//*[@class=\"retool-widget _retool-container-addressDropdown\"]//input[@class=\"ant-select-search__field\"]")
    private WebElement typeAddressLocator;
    @FindBy(xpath = "//*[contains (.,\"Specify address\") and contains (@class,'ant-select-selection__placeholder') ]")
    private WebElement selectTypeAddressLocator;
    @FindBy(xpath = "//li[@label=\"Wichita, KS, USA\"]")
    private WebElement selectAddress;
    private final String SELECT_ADDREESS = "//li[@label=\"Wichita, KS, USA\"]";

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement submitNewBusinessLocator;

    @FindBy(xpath = "//input[@placeholder=\"Search name, location or tag\"]")
    private WebElement searchBusinessLocator;

    @FindBy(xpath = "//div[ @class=\"rt-tr table-row selected -odd\" and contains(.,\"11test\")]//button[contains(.,\"Delete\")]")
    private WebElement deleteButtonLocator;
    private final String DELETE_BUTTON_LOCATOR = "//div[ @class=\"rt-tr table-row selected -odd\" and contains(.,\"11test\")]//button[contains(.,\"Delete\")]";

    @FindBy(xpath = "//div/p/*[contains(.,\"11test\")]")
    private WebElement deleteBusinessTextLocator;
    private final String DELETE_BUSINESS_TEXT_LOCATOR = "//div/p/*[contains(.,\"11test\")]";

    @FindBy(xpath = "//button [@class=\"ant-btn ant-btn-primary\" and contains(.,\"OK\")]")
    private WebElement confirmDeleteButtonLocator;


    public BusinessesPage(WebDriver driver) {
        super(driver);
    }

    public void addBusiness() throws InterruptedException {
        UtilMethods.setDriverExplicitWait(driver, TIME_OUT, ADD_BUSINESS_LOCATOR);
        addBusinessLocator.click();
        //waitSec(60);
    }

    public void typeNameOfBusiness() throws InterruptedException {
        UtilMethods.setDriverExplicitWait(driver, TIME_OUT, TYPE_NAME_LOCATOR);
        typeNameLocator.sendKeys("11test");
        // waitSec(10);
    }

    public void setCategoryOfBusiness() throws InterruptedException {
        // UtilMethods.setDriverExplicitWait(driver, TIME_OUT, TYPE_NAME_LOCATOR);
        selectCategoryField.click();
        UtilMethods.setDriverExplicitWait(driver, TIME_OUT, SELECT_CATEGORY);
        selectCategory.click();
    }

    public void typeDesctiptionOfBusiness() throws InterruptedException {
        // UtilMethods.setDriverExplicitWait(driver, TIME_OUT, TYPE_NAME_LOCATOR);
        descreptionLocator.sendKeys("TestTestTest");
    }

    public void setAddressOfBusiness() throws InterruptedException {
        // UtilMethods.setDriverExplicitWait(driver, TIME_OUT, TYPE_NAME_LOCATOR)
        selectTypeAddressLocator.click();
        typeAddressLocator.sendKeys("Wichita, KS, USA");
        UtilMethods.setDriverExplicitWait(driver, TIME_OUT, SELECT_ADDREESS);
        selectAddress.click();
    }

    public void submitNewBusiness() throws InterruptedException {
        // UtilMethods.setDriverExplicitWait(driver, TIME_OUT, TYPE_NAME_LOCATOR);
        submitNewBusinessLocator.click();
        //waitSec(2);
    }

    public void searchBusiness() throws InterruptedException {
        // UtilMethods.setDriverExplicitWait(driver, TIME_OUT, TYPE_NAME_LOCATOR);
        searchBusinessLocator.sendKeys("11test");
    }

    public void clickDeleteBusinessButton() throws InterruptedException {
        UtilMethods.setDriverExplicitWait(driver, TIME_OUT, DELETE_BUTTON_LOCATOR);
        deleteButtonLocator.click();
    }

    public void confirmDeleteBusiness() throws InterruptedException {
        UtilMethods.setDriverExplicitWait(driver, TIME_OUT, DELETE_BUSINESS_TEXT_LOCATOR);
        UtilMethods.highlightElement(driver, DELETE_BUSINESS_TEXT_LOCATOR);
        UtilMethods.verifyElementDisplayed(driver, DELETE_BUSINESS_TEXT_LOCATOR);
        waitSec(2);
        confirmDeleteButtonLocator.click();
        waitSec(30);
    }
}
