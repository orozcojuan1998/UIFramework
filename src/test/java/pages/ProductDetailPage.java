package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPage extends BasePage {

    @FindBy(xpath = "//div[@data-name]")
    private WebElement productName;

    @FindBy(xpath = "//*[@id=\"buttonForCustomers\"]/button")
    private WebElement buttonAdd;

    @FindBy(xpath = "//span[@class='jsx-3049166186 label']")
    private WebElement labelSuccess;

    @FindBy(xpath = "//a[@href=\"/falabella-co/basket\"]")
    private WebElement addToCart;

    private By addToCartFrame = By.xpath("//*[@id=\"__next\"]/div/div/div");
    private By addToCartButton = By.xpath("//*[@id=\"buttonForCustomers\"]/button");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void getProductDetail(){
        waitElement(addToCartButton);
        click(buttonAdd);
        waitElement(addToCartFrame);
    }

    public String getProductName(){
        return this.productName.getText();
    }

    public CartPage goToCartSummary() {
        click(addToCart);
        return new CartPage(driver);
    }


    public String getLabelSuccess() {
        return labelSuccess.getText();
    }
}
