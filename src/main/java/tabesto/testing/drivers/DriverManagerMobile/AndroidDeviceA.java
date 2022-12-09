package tabesto.testing.drivers.DriverManagerMobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import tabesto.testing.utils.HelpersMethod;


import java.io.IOException;

public class AndroidDeviceA {

    private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    HelpersMethod utils = new HelpersMethod();


    public static AppiumDriver getDriver() {
        return driver.get();
    }


    public static void setDriver(AppiumDriver driver2) {
        driver.set(driver2);
    }

    public void initializeDriver() throws Exception {
        AppiumDriver driver = null;

        if (driver == null) {
            try {
                utils.log().info("initializing Appium driver");
                driver = new AndroidDriver(new AppiumServer().getServer().getUrl(), new UiAutomatorOptions().getUiAutomatorOptionsMobile());
                if (driver == null) {
                    throw new Exception("driver is null. ABORT!!!");
                }
                utils.log().info("Driver is initialized");
                utils.log().info("session "+ driver.getSessionId());
                AndroidDeviceA.setDriver(driver);

            } catch (IOException e) {
                e.printStackTrace();
                utils.log().fatal("Driver initialization failure. ABORT !!!!" + e.toString());
                throw e;
            }
        }

    }
}
