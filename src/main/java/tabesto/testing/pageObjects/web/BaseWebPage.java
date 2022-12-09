package tabesto.testing.pageObjects.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tabesto.testing.drivers.DriverManagerWeb.ChromeDriverManager;
import tabesto.testing.drivers.DriverManagerWeb.DriverManager;
import tabesto.testing.drivers.DriverManagerWeb.ThreadLocalWebDriver;

import java.time.Duration;
import java.util.ArrayList;

import static tabesto.testing.drivers.DriverManagerWeb.DriverManager.driver;


public class BaseWebPage {

    private static final long TIMEOUT_WEB = 20;
    protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_WEB));

    protected static Logger logger = LogManager.getLogger();


    public static <T extends BaseWebPage> T instanceOfWeb(Class<T> clazz) {
        initWebdriver();
        return  PageFactory.initElements(ThreadLocalWebDriver.getThreadLocalWebDriver().getDriver(), clazz);
    }


    public void goToUrl(String url) {
        ThreadLocalWebDriver.getThreadLocalWebDriver().getDriver().get(url);
    }

    public static void initWebdriver() {
        if(ThreadLocalWebDriver.getThreadLocalWebDriver() == null){
            DriverManager chromeDriverManager = new ChromeDriverManager();
            ThreadLocalWebDriver.setThreadLocalWebDriver(chromeDriverManager);
            ThreadLocalWebDriver.getThreadLocalWebDriver().getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT_WEB));

        }
    }
    public boolean waitUrlContains(String pathUrl) {
        return wait.until(ExpectedConditions.urlContains(pathUrl));
    }

    public void switchWindows( int windows) {
        ArrayList tabs = new ArrayList (ThreadLocalWebDriver.getThreadLocalWebDriver().getDriver().getWindowHandles());
        ThreadLocalWebDriver.getThreadLocalWebDriver().getDriver().switchTo().window((String) tabs.get(windows));
    }
}
