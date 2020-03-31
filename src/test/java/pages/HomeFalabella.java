package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomeFalabella extends BasePage {

    @FindBy(id = "header-login-modal")
    private WebElement buttonLogin;

    @FindBy(id = "emailAddress")
    private WebElement inputEmail;

    @FindBy(className = "InputPassword__inputText__2IUUv")
    private WebElement inputPassword;


    @FindBy(xpath = "//*[@id=\"header-login-modal\"]//a[@href='/falabella-co/myaccount/register.jsp']")
    private WebElement registerLink;

    @FindBy(xpath = "//button/p[text() = 'Iniciar sesión']")
    private WebElement loginButton;

    @FindBy(id = "searchQuestionSolr")
    private WebElement searchBar;

    private By loginError = By.xpath("//div[@class ='Login__errorBlock__3q25u']");
    private By accountIcon = By.xpath("//div[@id='header-login-modal']/div/div/div/div[2]");
    private By errorMessageText = By.xpath("//div[@class='Login__errorBlock__3q25u']");
    private By louOutButton = By.xpath("//li/a[@class='fb-filter-header__log-out']");
    private By searchBarQuery = By.id("searchQuestionSolr");
    private By welcomeMessage = By.xpath("//div[@class='fb-masthead-login__name re-design-cl__name']");
    private By logOutBox = By.xpath("//div[@class='fb-masthead-login__name re-design-cl__name login-redesing_logout-box']");
    private By alertMessage = By.id("acc-alert-deny");

    public HomeFalabella(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public HomeFalabella goToThePage(String baseURL) {
        driver.get(baseURL);
        return this;
    }

    public WebElement getButtonLogin() {
        return buttonLogin;
    }

    public WebElement getInputEmail() {
        return inputEmail;
    }

    public WebElement getInputPassword() {
        return inputPassword;
    }

    public RegisterPage getRegisterLink() {
        click(this.registerLink);
        return new RegisterPage(driver);
    }

    public void sendCredentials(String user, String password) {
        writeText(inputEmail, user);
        writeText(inputPassword, password);
        click(loginButton);

    }

    public void login() {
        click(this.loginButton);


    }

    public void loginInvalid() {
        click(this.loginButton);
        WebDriverWait waitItems = new WebDriverWait(driver, Long.parseLong("7"));
        waitItems.until(ExpectedConditions.visibilityOfElementLocated(loginError));

    }

    public String getLoginText() {
        waitElement(welcomeMessage);
        WebElement welcomeMessage = driver.findElement(accountIcon);
        return welcomeMessage.getText();
    }

    public String getLoginErrorText() {
        waitElement(errorMessageText);
        WebElement errorMessage = driver.findElement(errorMessageText);
        return errorMessage.getText();


    }

    public void logOut() {
        waitElement(welcomeMessage);
        Actions action = new Actions(this.driver);
        WebElement subMenuLoginOption = driver.findElement(accountIcon);
        action.moveToElement(subMenuLoginOption).perform();
        WebElement logOut = driver.findElement(louOutButton);
        click(logOut);

    }

    public boolean getLogOutMessage() {
        waitElement(logOutBox);
        return buttonLogin.getText().toLowerCase().contains("inicia sesión");
    }

    public ProductsPage searchProduct(String query) {
       /* WebDriverWait waitItemAlert = new WebDriverWait(driver, Long.parseLong("8"));
        waitItemAlert.until(ExpectedConditions.visibilityOfElementLocated(alertMessage));
        WebElement alert = driver.findElement(alertMessage);
        click(alert);*/
        implicitWait(this.driver,5);
        waitElement(searchBarQuery);
        writeText(searchBar, query);
        searchBar.sendKeys(Keys.ENTER);
        return new ProductsPage(driver);
    }

    public void goToLoginForm() {
        click(buttonLogin);
    }
}
