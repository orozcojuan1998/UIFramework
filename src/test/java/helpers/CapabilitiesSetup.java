package helpers;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilitiesSetup {

    public CapabilitiesSetup() {
    }

    public ChromeOptions AndroidSetUp(String name) {

        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", System.getenv("SAUCE_USER"));
        sauceOptions.setCapability("accessKey",System.getenv("ACCESS_KEY"));
        sauceOptions.setCapability("screenResolution", "1280x1024");
        sauceOptions.setCapability("name",name);
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setExperimentalOption("w3c", true);
        browserOptions.setCapability("platformName", "Windows 10");
        browserOptions.setCapability("browserVersion", "79.0");
        browserOptions.setCapability("sauce:options", sauceOptions);

        return browserOptions;
    }
}
