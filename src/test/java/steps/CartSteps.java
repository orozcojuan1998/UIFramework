package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.HomeFalabella;
import pages.ProductDetailPage;
import pages.ProductsPage;

public class CartSteps {

    private final String responseExpected = "Producto(s) agregado(s) a la bolsa de compras";
    private WebDriver webDriver;
    private HomeFalabella homeFalabella;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private ProductDetailPage productDetailPage;

    public CartSteps (Hook hook){
        webDriver = hook.getDriver();
    }

    @Given("^The user has look for \"([^\"]*)\" in the search bar$")
    public void theUserHasLookForInTheSearchBar(String query) throws Throwable {
        homeFalabella = new HomeFalabella(webDriver);
        productsPage= homeFalabella.searchProduct(query);
    }

    @When("^The user adds a displayed product to his shopping cart$")
    public void theUserAddsADisplayedProductToHisShoppingCart() {
        productDetailPage = productsPage.getProduct();
        productDetailPage.getProductDetail();


    }

    @Then("^The user is informed that the product was added to the cart$")
    public void theUserIsInformedThatTheProductWasAddedToTheCart() {
        String response = productDetailPage.getLabelSuccess();
        Assert.assertEquals("El producto no fue añadido al carrito",responseExpected,response);
    }


    @And("^The user delete the product of the shopping cart$")
    public void theUserDeleteTheProductOfTheShoppingCart() {
        cartPage = productDetailPage.goToCartSummary();
        cartPage.deleteLink();
    }

    @Then("^The user is informed that its shopping cart is empty$")
    public void theUserIsInformedThatItsShoppingCartIsEmpty() {
        boolean deleteResponse = cartPage.getLabelEmpty();
        Assert.assertTrue("No sé puedo eliminar el item", deleteResponse);
    }
}
