package tabesto.testing.drivers.DriverManagerMobile;

import io.appium.java_client.android.AndroidDriver;

public class ThreadLocalDriver {
    public static final ThreadLocal<AndroidDriver> borneDriver = new ThreadLocal<>();

    public synchronized void setThreadLocalDriverBorne(AndroidDriver driver) { borneDriver.set(driver);}

    public static synchronized AndroidDriver getThreadLocalDriverBorne() {
        return borneDriver.get();
    }


}