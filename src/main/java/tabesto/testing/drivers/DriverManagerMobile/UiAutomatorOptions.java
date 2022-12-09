package tabesto.testing.drivers.DriverManagerMobile;

import io.appium.java_client.android.options.UiAutomator2Options;
import tabesto.testing.config.Settings;
import tabesto.testing.integration.reporter.GlobalParams;

import java.io.File;
import java.time.Duration;


public class UiAutomatorOptions {
    public UiAutomator2Options getUiAutomatorOptionsMobile() {
        GlobalParams params = new GlobalParams();
        String androidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                + File.separator + "resources" + File.separator + "apps" + File.separator + "app-qa-debug-1.3.0-rc.1.apk";


        UiAutomator2Options options = new UiAutomator2Options()
                .setAutomationName(Settings.getInstance().getAndroidAutomationName())
                .setPlatformName(params.getPlatformName())
                .setDeviceName(params.getDeviceName())
                .setUdid(params.getUDID())
                .setChromedriverPort(Integer.parseInt(params.getChromeDriverPort()))
                .setSystemPort(Integer.parseInt(params.getSystemPort()))
                .setApp(androidAppUrl)
                .setAppPackage(Settings.getInstance().getAndroidAppPackage())
                .setAppActivity(Settings.getInstance().getAndroidAppActivity())
                .autoGrantPermissions()
                .nativeWebScreenshot()
                .setAndroidInstallTimeout(Duration.ofMinutes(3))
                .setAppWaitDuration(Duration.ofSeconds(300))
                .setNewCommandTimeout(Duration.ofSeconds(600))
                .setUiautomator2ServerLaunchTimeout(Duration.ofSeconds(90))
                .setAppWaitForLaunch(true)
                .eventTimings()
                .clearDeviceLogsOnStart().setAdbExecTimeout(Duration.ofSeconds(50))
                .noReset();
        return options;
    }
}

