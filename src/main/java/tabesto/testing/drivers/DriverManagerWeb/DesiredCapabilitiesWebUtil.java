package tabesto.testing.drivers.DriverManagerWeb;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;

public class DesiredCapabilitiesWebUtil {

    public ChromeOptions getDesiredCapabilitiesWeb() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        options.setCapability(CapabilityType.LOGGING_PREFS, new LoggingPreferences());
        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
        options.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
        options.setAcceptInsecureCerts(true);
        options.setCapability("chrome.binary","./src//lib//chromedriver");
        return options;
    }


}
