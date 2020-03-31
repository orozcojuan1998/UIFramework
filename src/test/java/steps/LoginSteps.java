package steps;

import builders.UserBuilder;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import entities.User;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomeFalabella;

import java.util.List;
import java.util.Map;

public class LoginSteps {

    private WebDriver webDriver;
    private User user;
    private HomeFalabella homeFalabella;

    public LoginSteps (Hook hook){
        webDriver = hook.getDriver();
    }


    @Given("^The user is in the Falabella homepage$")
    public void theUserIsInTheFalabellaHomepage()
    {
        homeFalabella = new HomeFalabella(webDriver);
        user = new User();
    }

    @When("^The the user tries to login with its data$")
    public void theTheUserTriesToLoginWithItsData(DataTable userData) {
        homeFalabella.goToLoginForm();
        List<Map<String, String>> data = userData.asMaps(String.class, String.class);
        user = new UserBuilder().
                withEmail(data.get(0).get("email")).
                withPassword(data.get(0).get("password")).create();
        homeFalabella.sendCredentials(user.getEmail(), user.getPassword());

    }

    @Then("^The user is signed in$")
    public void theUserIsSignedIn() {
        String text = homeFalabella.getLoginText();
        Assert.assertEquals("Login invalido", "Bienvenid@,\n" +
                "Juan David", text);
    }

    @Then("^The user stays in the same page and is informed that credentials are wrong$")
    public void theUserStaysInTheSamePageAndIsInformedThatCredentialsAreWrong() {
        String text = homeFalabella.getLoginErrorText();
        Assert.assertEquals("Login invalido", "E-mail o clave incorrecta. Por favor inténtalo nuevamente.", text);
    }

    @Given("^The user is in the application home page logged in$")
    public void theUserIsInTheApplicationHomePageLoggedIn() {
        homeFalabella = new HomeFalabella(webDriver);
        user = new User();
        homeFalabella.goToLoginForm();
        user = new UserBuilder().
                withEmail(System.getenv("USER")).
                withPassword(System.getenv("PASSWORDF")).create();
        homeFalabella.sendCredentials(user.getEmail(), user.getPassword());

    }

    @When("^The user hover on the account button and clicks the log out button$")
    public void theUserHoverOnTheAccountButtonAndClicksTheLogOutButton() {
        homeFalabella.logOut();
    }


    @Then("^The user is logout from the web page$")
    public void theUserIsLogoutFromTheWebPage() {
        boolean logOutResponse = homeFalabella.getLogOutMessage();
        Assert.assertTrue("Logout invalido", logOutResponse);
    }

}
