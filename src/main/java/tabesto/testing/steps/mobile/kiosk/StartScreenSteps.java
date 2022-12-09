package tabesto.testing.steps.mobile.kiosk;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import tabesto.testing.config.Settings;
import tabesto.testing.pageObjects.mobile.kiosk.StartScreenBorne;

import java.net.MalformedURLException;


public class StartScreenSteps{

    @Given("Kiosk app is started correctly")
    public void user_is_on_start_screen() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(new StartScreenBorne().verifyVisibilityElement());
    }

    @Given("Kiosk app is launched")
    @Given("Kiosk app is relaunched")
    public void kiosk_app_is_launched() throws MalformedURLException {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //new StartScreenBorne().kioskAppLaunched();
       // Assert.assertTrue (touchBorne.verifyVisibleElementsOnScreen());
    }

    @Given("Kiosk app is launched and configured")
    public void kiosk_app_is_launched_configured() throws MalformedURLException {
        try {
            Thread.sleep(10000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //new StartScreenBorne().kioskAppLaunched();
        //Assert.assertTrue (.verifyVisibleElementsOnScreen());
    }

    @Given("Url server is configured")
    public void url_server_is_configured()  throws InterruptedException {
        new StartScreenBorne().clickOnDebugMode();
        new StartScreenBorne().setServerUrlInput(Settings.getInstance().getBaseUrl());
        new StartScreenBorne().clickOnOkButton();
    }
    @When("App is synchronized")
    public void app_is_synchronized() throws InterruptedException {
        new StartScreenBorne().clickOnDebugMode().clickOnOkButton();
        Thread.sleep(60000);
    }

    @Then("Message {string} is displayed on start screen")
    public void message_is_displayed_on_start_screen(String msg) {
        Assert.assertEquals(new StartScreenBorne().getSplashScreenStatus(), msg);
    }

    @When("User hold press on icon Tabesto")
    public void user_hold_press_on_icon_tabesto() {
        new StartScreenBorne().clickOnIconTabesto();
    }

    @Then("Dialog with pin lock view still present")
    @Then("Dialog with pin lock view appears")
    public void dialog_with_pin_lock_view_appears_still_present() {
        Assert.assertTrue(new StartScreenBorne().verifyPresentDialog());
    }


    @When("User click on cancel button")
    public void user_click_on_cancel_button() {
        new StartScreenBorne().clickOnCancelButton();
    }

    @Then("Dialog with pin lock view disappears")
    public void dialog_with_pin_lock_view_disappears() {
        Assert.assertTrue(new StartScreenBorne().verifyInvisibilityDialogPinLock());
    }

    @When("User press passcode {int},{int},{int},{int}")
    public void user_press_code(int code1,int code2,int code3, int code4) {
        new StartScreenBorne().pressPassCode(code1-1);
        new StartScreenBorne().pressPassCode(code2-1);
        new StartScreenBorne().pressPassCode(code3-1);
        new StartScreenBorne().pressPassCode(code4-1);
    }

    @When("User set as server url")
    public void user_set_server_url()  {
        //instanceOf(StartScreenBorne.class).setServerUrlInput(FileReaderManager.getInstance().getJsonReader().getProductData().getJSONObject("env").get("boUrl").toString());

    }
    @When("User change language")
    public void user_change_language(){
        new StartScreenBorne().pressLanguageButton();
    }

    @When("User set oca url")
    public void user_set_oca_url() {
        //instanceOf(StartScreenBorne.class).setServerOcaInput(FileReaderManager.getInstance().getJsonReader().getProductData().getJSONObject("env").get("ocaUrl").toString());

    }
    @When("User click on Ok button")
    public void user_click_on_ok_button() {
        new StartScreenBorne().clickOnOkButton();
    }

    @When("Button Test printer is present")
    public void button_test_printer_is_present() {
        new StartScreenBorne().verifyDisplayTestPrinterButton();
    }

    @When("User click on try button")
    public void user_click_on_try_button() {
        new StartScreenBorne().clickOnTryButton();
    }

    @When("User click on debug mode")
    public void user_click_on_debug_mode() throws InterruptedException {
        new StartScreenBorne().clickOnDebugMode();
    }

    @Then("Name screen of kiosk app is displayed")
    public void nameScreenOfKioskAppIsDisplayed() {

    }
    @When("User ignore eventSuggestion")
     public void ignoreEventSuggestion() {
        new StartScreenBorne().ignoreSuggestion();
    }

}
