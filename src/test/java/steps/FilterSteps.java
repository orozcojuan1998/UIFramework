package steps;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomeFalabella;
import pages.ProductsPage;

public class FilterSteps {

    private WebDriver webDriver;
    private HomeFalabella homeFalabella;
    private ProductsPage productsPage;
    private String fromRange;
    private String toRange;

    public FilterSteps (Hook hook){
        webDriver = hook.getDriver();
    }

    @Given("^The guest user is in the Falabella homepage$")
    public void theGuestUserIsInTheFalabellaHomepage() {
        homeFalabella = new HomeFalabella(webDriver);
    }

    @And("^The guest type \"([^\"]*)\" in the search bar$")
    public void theGuestTypeInTheSearchBar(String query) throws Throwable {
        productsPage= homeFalabella.searchProduct(query);
    }


    @When("^The guest apply the price for filter between \"([^\"]*)\" and \"([^\"]*)\"$")
    public void theGuestApplyThePriceForFilterBetweenAnd(String rangeFrom, String rangeTo) throws Throwable {
        fromRange = rangeFrom;
        toRange = rangeTo;
        productsPage.setPriceFilter(rangeFrom,rangeTo);
    }

    @Then("^The guest should just see products in the given range$")
    public void theGuestShouldJustSeeProductsInTheGivenRange() {
        Boolean response = productsPage.getResults(fromRange,toRange);
        Assert.assertTrue("Prices are displayed incorrectly", response);
    }

}
