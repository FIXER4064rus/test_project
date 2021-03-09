package maksim_klimenko1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

    @FindBy(xpath = "//*[@track-name=\"seePricing\"]")
    private WebElement seePriceLocator;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void goToPricingPage() {
        seePriceLocator.click();
    }
}
