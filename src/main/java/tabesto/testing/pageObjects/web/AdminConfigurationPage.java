package tabesto.testing.pageObjects.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AdminConfigurationPage extends BaseWebPage {

    @FindBy(css = "tbody tr")
    private List<WebElement> allDevices;
    @FindBy(xpath = "//select[@id='user_defaultTable']")
    private WebElement numTable;
    @FindBy(id = "top-navigation-form-save-button")
    private WebElement saveButton;
    @FindBy(xpath = "//*[@id='configEditType_DISPLAY_TOP_BAR_0']//parent::*")
    private  WebElement displayBarRadio;



    public void activateMultilingual() {
    }

    public void verifyActivateMultilingual() {
    }
}
