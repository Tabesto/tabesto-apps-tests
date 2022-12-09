package tabesto.testing.steps.mobile;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import tabesto.testing.pageObjects.mobile.kiosk.TouchBorne;
import tabesto.testing.pageObjects.nativeMobile.*;


public class NativeMobileSteps {

    @Then("Alert {string} appears")
    public void alert_title_appears(String alertTitle) {
        Assert.assertEquals(new AlertMobilePage().getAlertText(), alertTitle);
    }

    @When("User click on open app again")
    public void user_click_on_open_app_again() {
        new AlertMobilePage().clickOnOpenAgain();
    }

    @When("Toast message {string} is displayed")
    public void toast_message_is_displayed(String msg) {
       Assert.assertEquals(new TouchBorne().getToast(), msg);
    }



}
