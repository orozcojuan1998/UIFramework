package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import drivermanager.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategorySteps {

    private DriverManager driverManager;
    private WebDriver webDriver;

    public CategorySteps(Hooks hooks){
        driverManager = hooks.getDriverManager();
        webDriver = driverManager.getDriver();

    }

    @Given("^The user is in the iamlittletester Homepage$")
    public void theUserIsInTheIamlittletesterHomepage() {
        
    }

    @When("^The user goes to the comics category$")
    public void theUserGoesToTheComicsCategory() throws InterruptedException {
        WebElement tittleComics = webDriver.findElement(By.id("menu-item-2008"));
        tittleComics.click();
    }

    @Then("^The user is redirected to the comics category page$")
    public void theUserIsRedirectedToTheComicsCategoryPage() throws InterruptedException {
        By title = By.className("page-title");
        WebDriverWait waitTitle = new WebDriverWait(webDriver,5);
        waitTitle.until(ExpectedConditions.visibilityOfElementLocated(title));
        WebElement pageTitle = webDriver.findElement(title);
        Assert.assertTrue("Cannot redirect to comics page",pageTitle.isDisplayed());
        Assert.assertEquals("Category: comics",pageTitle.getText());
    }
}
