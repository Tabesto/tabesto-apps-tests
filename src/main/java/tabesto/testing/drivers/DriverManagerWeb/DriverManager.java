package tabesto.testing.drivers.DriverManagerWeb;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    public static WebDriver driver;
    protected abstract void startService();
    protected abstract void stopService();

    public WebDriver getDriver() {
        if (driver == null ) {
            startService();
        }
        return driver;
    }
}
