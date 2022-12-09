package com.runners;


import io.cucumber.testng.*;
import org.apache.logging.log4j.ThreadContext;
import org.testng.annotations.*;
import tabesto.testing.model.DataSet;
import tabesto.testing.drivers.DriverManagerMobile.AndroidDeviceA;
import tabesto.testing.drivers.DriverManagerMobile.AppiumServer;
import tabesto.testing.integration.reporter.GlobalParams;
import tabesto.testing.utils.HelpersMethod;

import java.io.File;
import java.time.Duration;


public class RunnerBase {

    private static ThreadLocal<TestNGCucumberRunner> testNGCucumberRunner = new ThreadLocal<>();

    public static TestNGCucumberRunner getRunner(){
        return testNGCucumberRunner.get();
    }

    private static void setRunner(TestNGCucumberRunner testNGCucumberRunner1){
        testNGCucumberRunner.set(testNGCucumberRunner1);
    }

    @Parameters({"platformName", "udid", "deviceName", "systemPort",
            "chromeDriverPort"})
    @BeforeClass(alwaysRun = true)
     public void setUpClass(String platformName, String udid, String deviceName, @Optional("Android") String systemPort,
                           @Optional("Android") String chromeDriverPort) throws Exception {


        GlobalParams params = new GlobalParams();
        String strFile = "logs" + File.separator + "Android";
        File logFile = new File(strFile);
        if (!logFile.exists()){
            logFile.mkdirs();
        }
        ThreadContext.put("ROUTINGKEY", strFile);
        params.setPlatformName(platformName);
        params.setUDID(udid);
        params.setDeviceName(deviceName);
        params.setSystemPort(systemPort);
        params.setChromeDriverPort(chromeDriverPort);
        new AppiumServer().startServer();
        new AndroidDeviceA().initializeDriver();
        new AndroidDeviceA().getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        setRunner(new TestNGCucumberRunner(this.getClass()));
        String command = "adb -s "+params.getUDID()+" shell getprop ro.build.version.release";
        String osVersion = HelpersMethod.readOutputStream("(\\d+)",command);
        if (osVersion != null){
            DataSet.getInstance().setVersionOs(osVersion);
        }
        command = "adb -s "+params.getUDID()+" shell dumpsys package com.tabesto.kiosk.debug";
        String appVersion = HelpersMethod.readOutputStream("versionName=(\\d.\\d.\\d)",command);
        System.out.println("version"+appVersion);
        if (appVersion != null){
            DataSet.getInstance().setAppVersion(appVersion);
        }else {
            DataSet.getInstance().setAppVersion("1.3.0");
        }
    }


    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void
    scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature) throws Throwable {
        getRunner().runScenario(pickle.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        return getRunner().provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass(){
        AndroidDeviceA driverManager = new AndroidDeviceA();
            if(driverManager.getDriver() != null){
                driverManager.getDriver().quit();
                driverManager.setDriver(null);
            }
            AppiumServer serverManager = new AppiumServer();
            if(serverManager.getServer() != null){
                serverManager.getServer().stop();
            }
            if(testNGCucumberRunner != null){
                getRunner().finish();
            }

    }
}
