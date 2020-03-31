package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import drivermanager.DriverManager;
import drivermanager.DriverType;
import helpers.CapabilitiesSetup;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;

public class Hook {

    private RemoteWebDriver driver;
    private DriverManager driverManager = new DriverManager();
    private CapabilitiesSetup capabilitiesSetup = new CapabilitiesSetup();
    public final String url = "https://www.falabella.com.co/falabella-co/";


    @Before
    public void setUp(Scenario scenario) throws MalformedURLException {
        driver = driverManager.getDriver(capabilitiesSetup.AndroidSetUp(scenario.getName()));
        this.driver.get(url);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            ((JavascriptExecutor) driver).executeScript("sauce:job-result=" + ("failed"));
        } else {
            ((JavascriptExecutor) driver).executeScript("sauce:job-result=" + ("passed"));
        }

        driverManager.quitDriver();
    }


    public RemoteWebDriver getDriver() {
        return driver;
    }}
