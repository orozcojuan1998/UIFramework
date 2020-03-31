package steps;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import entities.User;

import helpers.UserCreation;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.HomeFalabella;
import pages.RegisterPage;

public class RegisterSteps {

    private RemoteWebDriver webDriver;
    private UserCreation userCreation= new UserCreation();
    private User user;

    private HomeFalabella homeFalabella;
    private RegisterPage registerPage;


    public RegisterSteps (Hook hook){
        webDriver = hook.getDriver();
    }


    @Given("^The user is in the register form$")
    public void theUserIsInTheRegisterForm() {
        user = userCreation.buildUserWithoutCellphone();
        homeFalabella = new HomeFalabella(webDriver);
        homeFalabella.goToLoginForm();
        registerPage = homeFalabella.getRegisterLink();

    }

    @When("^The user tries to register with invalid cellphone$")
    public void theUserTriesToRegisterWithInvalidCellphone() {
        registerPage.enterData(user);
        registerPage.clickRegisterButton();

    }


    @Then("^The user stays in the same page and is informed that cellphone is required$")
    public void theUserStaysInTheSamePageAndIsInformedThatCellphoneIsRequired() {
        String textResponse = registerPage.getRegisterMessageError();
        Assert.assertEquals("Login invalido", "Debes ingresar un celular", textResponse);

    }

}
