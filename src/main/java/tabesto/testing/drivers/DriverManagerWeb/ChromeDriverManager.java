package tabesto.testing.drivers.DriverManagerWeb;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static tabesto.testing.utils.WaitConfig.TIMEOUT_WEB;

public class ChromeDriverManager extends DriverManager {

    @Override
    public void startService() {
        if ( driver == null ) {
            DesiredCapabilitiesWebUtil capabilitiesWebUtil= new DesiredCapabilitiesWebUtil();
            capabilitiesWebUtil.getDesiredCapabilitiesWeb().setCapability("chrome.binary",System.setProperty("webdriver.chrome.driver", "src/lib//chromedriver.exe"));
            driver = new ChromeDriver(capabilitiesWebUtil.getDesiredCapabilitiesWeb());
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT_WEB));
            driver.manage().timeouts().implicitlyWait(TIMEOUT_WEB, TimeUnit.SECONDS);
            driver.manage().window().maximize();

        }
    }
 
    @Override
    protected void stopService() {
        if (driver == null ) {
            driver.close();
        }
    }

}
