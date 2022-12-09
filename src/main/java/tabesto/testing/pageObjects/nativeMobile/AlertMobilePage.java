package tabesto.testing.pageObjects.nativeMobile;

import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import tabesto.testing.pageObjects.mobile.BaseMobile;

public class AlertMobilePage extends BaseMobile {
    @AndroidFindBy(id = "android:id/alertTitle")
    private WebElement alertText;
    @AndroidFindBy(id = "android:id/aerr_restart")
    private WebElement alertButton;



    public String getAlertText() {
        return alertText.getText();
    }
    public void clickOnOpenAgain() {
        alertButton.click();
    }
}
