package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import drivermanager.DriverManager;
import drivermanager.DriverManagerFactory;
import drivermanager.DriverType;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private WebDriver driver;
    private DriverManagerFactory driverManagerFactory = new DriverManagerFactory();
    private DriverManager driverManager;


    @Before
    public void setUp() {
        driverManager = driverManagerFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
        driver.get("https://imalittletester.com/");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driverManager.quitDriver();
    }

    public DriverManager getDriverManager() {
        return driverManager;
    }
}
