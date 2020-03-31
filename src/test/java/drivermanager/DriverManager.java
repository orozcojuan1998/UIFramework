package drivermanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Remote;

public class DriverManager {

    private RemoteWebDriver driver;

    protected void createDriver(ChromeOptions desiredCapabilities) throws MalformedURLException {
        driver = new RemoteWebDriver(new URL("http://ondemand.saucelabs.com:80/wd/hub"),desiredCapabilities);
    }

    public void quitDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }

    public RemoteWebDriver getDriver(ChromeOptions desiredCapabilities) throws MalformedURLException {
        if (driver == null){
            createDriver(desiredCapabilities);
        }
        return driver;
    }


}
