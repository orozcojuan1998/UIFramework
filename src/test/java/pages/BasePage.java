package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element) {
        element.click();
    }
    public void clear(WebElement element) {
        element.clear();
    }

    public void writeText(WebElement element, String word) {
        element.sendKeys(word);
    }
    public void implicitWait (WebDriver webDriver, long seconds){
        webDriver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }
    public void waitElement (By element){
        WebDriverWait waitItems = new WebDriverWait(driver, Long.parseLong("10"));
        waitItems.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

}