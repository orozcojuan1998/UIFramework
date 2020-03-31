package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

    @FindBy(xpath = "//form/div/p")
    private WebElement labelEmpty;

    @FindBy(xpath = "//a[text()='Eliminar']")
    private WebElement deleteLink;



    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void deleteLink() {
        implicitWait(driver,4);
        click(deleteLink);
    }

    public boolean getLabelEmpty() {
        implicitWait(driver,4);
        System.out.println(labelEmpty.getText());
        return labelEmpty.getText().toLowerCase().contains("tu bolsa de compras está vacía");
    }
}
