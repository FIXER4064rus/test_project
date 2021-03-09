package maksim_klimenko1.stepdefs;

import maksim_klimenko1.pages.CalcPage;
import maksim_klimenko1.pages.PricingPage;
import maksim_klimenko1.pages.ProductsPage;
import maksim_klimenko1.pages.StartPage;
import maksim_klimenko1.singletone.SingletoneWebDriver;
import cucumber.api.java.en.*;


public class CalcSearchStepDefs {


    @Given("^I opened new page$")
    public void openedNewPage() {
        StartPage startPage = new StartPage(SingletoneWebDriver.getWebDriverInst());
        startPage.openPage();
        startPage.setImplicitlyWait();
        startPage.maximizeWindow();

    }

    @And("^I move to product page$")
    public void moveToProductPage() {
        StartPage startPage = new StartPage(SingletoneWebDriver.getWebDriverInst());
        startPage.goToProductsPage();

    }

    @And("^I move to pricing page$")
    public void moveToPricingPage() {
        ProductsPage productsPage = new ProductsPage(SingletoneWebDriver.getWebDriverInst());
        productsPage.goToPricingPage();

    }

    @And("^I Select calc$")
    public void selectCalc() {
        PricingPage pricingPage = new PricingPage(SingletoneWebDriver.getWebDriverInst());
        pricingPage.clickCalc();
    }


    @When("^I Write \"([^\"]*)\"$")
    public void writeSearch(String search) throws InterruptedException {
        CalcPage calcPage = new CalcPage(SingletoneWebDriver.getWebDriverInst());
        calcPage.switchToCalcFrame();
        calcPage.maximizeWindow();
        calcPage.typeSearch(search);
    }


    @Then("^I Check result \"([^\"]*)\"$")
    public void checkResult(String result) {
        CalcPage calcPage = new CalcPage(SingletoneWebDriver.getWebDriverInst());
        calcPage.checkResult(result);

    }
}