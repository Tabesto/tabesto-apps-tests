package tabesto.testing.integration.reporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntry;
import tabesto.testing.config.ConfigReader;
import tabesto.testing.config.Settings;
import tabesto.testing.drivers.DriverManagerMobile.AndroidDeviceA;
import tabesto.testing.utils.VideoRecorder;

import java.io.*;
import java.util.List;
import java.util.UUID;


public class Hooks {
    GlobalParams params = new GlobalParams();

    private static ThreadLocal<String> scenarioName = new ThreadLocal<String>();
    private static ThreadLocal<String> uuid = new ThreadLocal<String>();


    public static String getUuid() {
        return uuid.get();
    }

    public static void setUuid() {
        uuid.set(UUID.randomUUID().toString());
    }

    public static String getScenarioName() {
        return scenarioName.get();
    }

    public static void setScenarioName(String deviceName2) {
        scenarioName.set(deviceName2);
    }



    @Before
    public void initialize(Scenario scenario) throws IOException {
        setUuid();

        if (Settings.getInstance().isVideoEnable()){
            new VideoRecorder().startRecording();
        }
        try {
            String clearLogcat = "adb -s "+params.getUDID()+" logcat -c";
            Runtime.getRuntime().exec(clearLogcat);
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setScenarioName(scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) throws IOException {
        if(scenario.isFailed()) {
            final byte [] screenshot = ((TakesScreenshot) new AndroidDeviceA().getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
            try {
                String closeApp = "adb -s "+params.getUDID()+" shell am force-stop com.tabesto.kiosk.debug";
                Runtime.getRuntime().exec(closeApp);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                String startApp="adb -s "+params.getUDID()+" shell am start com.tabesto.kiosk.debug/com.tabesto.kiosk.ui.start.StartActivity";
                Runtime.getRuntime().exec(startApp);
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (Settings.getInstance().isVideoEnable()){
            new VideoRecorder().stopRecording(scenario.getName(),getUuid());
        }
        AndroidDeviceA driverManager = new AndroidDeviceA();
        List<LogEntry> logs = driverManager.getDriver().manage().logs().get("logcat").getAll();
        File logsDir = new File("AppiumLogs/logsAdb/" + params.getDeviceName()+"_"+scenario.getName());
        synchronized (logsDir) {
            if(!logsDir.exists()) {
                logsDir.mkdirs();
            }
        }
        File logsAdb =  new File(logsDir + File.separator + getUuid()+".log");
        try {
            PrintWriter log_file_writer = new PrintWriter(logsAdb);
            for (LogEntry log : logs) {
                if (!log.getMessage().contains("appium"))
                    log_file_writer.println(log);

            }

        }catch (Exception e){
        }
    }
}
