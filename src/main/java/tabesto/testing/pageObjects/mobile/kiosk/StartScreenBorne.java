package tabesto.testing.pageObjects.mobile.kiosk;

import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import tabesto.testing.pageObjects.mobile.BaseMobile;

import java.util.List;
import tabesto.testing.utils.HelpersMethod;
import tabesto.testing.utils.generator.FakerData;

public class StartScreenBorne extends BaseMobile {
    HelpersMethod utils = new HelpersMethod();


    @FindBy(id = "imageview_splashscreen_logo")
    private WebElement iconTabesto;

    @FindBy(id = "textview_splashscreen_status")
    private WebElement textStatus;

    @FindBy(id = "button_splashscreen_retry")
    private WebElement retryButton;

    @FindBy(id = "imageview_dialog_settings_icon")
    private WebElement pinLockDialog;

    @FindBy(id = "button_dialog_settings_negative")
    private WebElement cancelButton;

    @AndroidFindAll(value = { @AndroidBy (id = "button")}, priority = 0)
    private List<WebElement> keysPinLock;

    @FindBy(id = "edittext_settings_bo_url")
    private WebElement serverUrlInput;

    @FindBy(id = "edittext_settings_oca_url")
    private WebElement serverOcaUrl;

    @FindBy(id = "button_dialog_settings_validate")
    private WebElement oKButton;

    @FindBy(id = "button_dialog_settings_print")
    private WebElement testPrinterButton;

    @FindBy(id = "screenshotContainer")
    private WebElement srcImage;
    @FindAll({ @FindBy(id = "button_event_suggestion_dismiss")})
    private List<WebElement> ignoreSuggestion;

    @FindAll({ @FindBy(id = "imageview_language_icon")})
    private List<WebElement> changeLanguage;

    @FindBy(id = "textview_splashscreen_git")
    private WebElement appVersion;

    @FindBy(id = "button_splashscreen_debug")
    private WebElement debugButton;


    public StartScreenBorne clickOnDebugMode() throws InterruptedException {
        action_clickOnPosition(125,96);
        return this;
    }

    public String getAppVersion(){
        return appVersion.getText();
    }

    public String getSplashScreenStatus() { return textStatus.getText();}

    public boolean verifyVisibilityElement(){
       return verifyDisplayElement(iconTabesto);
    }

    public void clickOnIconTabesto() {
        longPress(iconTabesto);
    }

    public boolean verifyPresentDialog() {
        return verifyDisplayElement(pinLockDialog);
    }

    public boolean verifyInvisibilityDialogPinLock() {
        try {
           return verifyDisplayElement(pinLockDialog);
        } catch (NoSuchElementException exception){ return true;}
    }

    public void clickOnCancelButton() {
        cancelButton.click();
    }

    public void ignoreSuggestion() {
        if (!ignoreSuggestion.isEmpty()) {
            ignoreSuggestion.get(0).click();
        }
    }
    public void pressLanguageButton(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (changeLanguage.size() > 0) {
            WebElement lang = FakerData.pickRandom(changeLanguage, 1).get(0);
            lang.click();
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lang = FakerData.pickRandom(changeLanguage.subList(1, changeLanguage.size()), 1).get(0);
            lang.click();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void pressPassCode(int code) {
        keysPinLock.get(code).click();
    }

    public void clickOnTryButton() {
        retryButton.click();
    }

    public void clickOnOkButton() {
        oKButton.click();
    }

    public void setServerUrlInput(String urlInput)  {
        serverUrlInput.clear();
        serverUrlInput.sendKeys(urlInput);
    }
    public void setServerOcaInput(String urlOca)  {
        serverOcaUrl.clear();
        serverOcaUrl.sendKeys(urlOca);
    }

    public boolean verifyDisplayTestPrinterButton() {
       return testPrinterButton.isDisplayed();
    }




}
