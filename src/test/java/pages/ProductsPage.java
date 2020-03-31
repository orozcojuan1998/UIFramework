package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class ProductsPage extends BasePage {

    @FindBy(id = "testId-Accordion-Precio")
    private WebElement buttonPrice;

    @FindBy(id = "testId-range-from")
    private WebElement rangeFrom;

    @FindBy(id = "testId-range-to")
    private WebElement rangeTo;

    @FindBy(xpath = "//button[@class = 'jsx-3084763500']")
    private WebElement buttonForFilter;

    private By resultSearch = By.id("testId-searchResults-products");
    private By searchResults = By.xpath("//*[@id=\"testId-searchResults-products\"]/div");
    private By filterPriceButton = By.id("testId-Accordion-Precio");


    public ProductsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void setPriceFilter(String from, String to) {

        waitElement(filterPriceButton);
        click(buttonPrice);
        writeText(rangeFrom, from);
        writeText(rangeTo, to);
        click(buttonForFilter);

    }

    public Boolean getResults(String from, String to) {
        List<WebElement> results;
        waitElement(resultSearch);
        List<Integer> prices = new ArrayList<>();
        int contFilterElements = 0;
        waitElement((searchResults));
        results = driver.findElements(searchResults);
        for (WebElement element : results) {
            String price = (element.getText().substring(element.getText().indexOf('$') + 2, element.getText().indexOf('$') + 9));
            int indexOfDecimal = price.indexOf(".");
            String integerPart = price.substring(0, indexOfDecimal);
            String decimalPart = price.substring(indexOfDecimal + 1);
            integerPart = integerPart.concat(decimalPart);
            prices.add(Integer.valueOf(integerPart));
        }

        for (Integer price : prices) {
            if (price <= Integer.parseInt(to)) {
                contFilterElements++;
            } else {
                return false;
            }
        }
        boolean arePricesInTheRage = false;
        if (contFilterElements == prices.size()) {
            arePricesInTheRage = true;
        }
        return arePricesInTheRage;
    }

    public ProductDetailPage getProduct() {
        List<WebElement> results;
        waitElement(resultSearch);
        results = driver.findElements(searchResults);
        click(results.get(3));
        return new ProductDetailPage(driver);
    }
}
