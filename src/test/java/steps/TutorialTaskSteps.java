package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import drivermanager.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TutorialTaskSteps {

    private DriverManager driverManager;
    private WebDriver webDriver;

    public TutorialTaskSteps(Hooks hooks){
        driverManager = hooks.getDriverManager();
        webDriver = driverManager.getDriver();
    }

    @When("^The user goes to the tutorials and taks page$")
    public void theUserGoesToTheTutorialsAndTaksPage() {
        WebElement tutorialTalksButton = webDriver.findElement(By.id("menu-item-2007"));
        tutorialTalksButton.click();
    }

    @Then("^The grid of talks is visible$")
    public void theGridOfTalksIsVisible() {
        By title = By.className("page-liner");
        WebDriverWait waitTitle = new WebDriverWait(webDriver,5);
        waitTitle.until(ExpectedConditions.visibilityOfElementLocated(title));
        WebElement pageTitle = webDriver.findElement(title);
        Assert.assertTrue("Cannot redirect to talks page page",pageTitle.isDisplayed());

    }
}
