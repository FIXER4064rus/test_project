package maksim_klimenko1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PricingPage extends BasePage {

    private @FindBy(xpath = "//*[@id=\"cloud-site\"]/*/*/*[@class=\"cloud-jump-menu__toggle\"]")
    WebElement calcDropDownLocator;

    private @FindBy(xpath = "//*[@track-name=\"pricingNav/calculators\"]")
    WebElement goToCalcLocator;

    @FindBy(xpath = "//*[@track-name=\"pricingNav/calculators\"]")
    private WebElement calcButtonLocator;


    public void clickCalc() {
        calcButtonLocator.click();
    }

    public PricingPage(WebDriver driver) {
        super(driver);
    }

    public void clickDropdown() {
        calcDropDownLocator.click();
    }


    public void goToCalcPage() {
        goToCalcLocator.click();
    }

}
