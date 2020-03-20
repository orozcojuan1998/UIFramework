package drivermanager;

public class DriverManagerFactory {

    public DriverManager getManager(DriverType type){
        DriverManager driverManager ;

        switch (type){
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            default:
                throw new IllegalArgumentException("");
        }
        return driverManager;
    }
}
