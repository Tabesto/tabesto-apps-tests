package tabesto.testing.steps.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tabesto.testing.pageObjects.web.AdminConfigurationPage;
import tabesto.testing.pageObjects.web.AdminTablettesPage;
import tabesto.testing.pageObjects.web.ProductPage;

import static tabesto.testing.pageObjects.web.BaseWebPage.instanceOfWeb;

public class AdministrationSteps extends BaseWebSteps {

    @When("User edit default table as {string} for tab name {string}")
    public void user_click_on_menuItem(String titleTab, String defaultTab) {
        instanceOfWeb(AdminTablettesPage.class).selectTab(titleTab);
        instanceOfWeb(AdminTablettesPage.class).switchWindows(1);
        instanceOfWeb(AdminTablettesPage.class).waitUrlContains("tablet/edit");
        instanceOfWeb(AdminTablettesPage.class).updateTabletDetails(defaultTab);
        instanceOfWeb(AdminTablettesPage.class).clickOnSaveButton();
        instanceOfWeb(AdminTablettesPage.class).waitUrlContains("/tablet/list");
    }

    @When("User activate option bar menu")
    public void user_activate_option_bar_menu(){
        instanceOfWeb(AdminTablettesPage.class).activateBarMenu();
        instanceOfWeb(AdminTablettesPage.class).clickOnSaveButton();
    }

    @When("Borne is configured")
    public void user_configure_borne () {
        instanceOfWeb(AdminTablettesPage.class).configureBorneInBackOffice();
    }

    @And("User select {string} as client identification")
    public void user_mode_identification(String typeIden) {
    }

    @Then("Verify error message {string}")
    public void verify_message(String errorMsg) {
        instanceOfWeb(ProductPage.class).verifyErrorMessage(errorMsg);
    }

    @Then("New-user activate option multilingual")
    @Then("User activate option multilingual")
    public void user_activate_multilingual() {
        instanceOfWeb(AdminConfigurationPage.class).activateMultilingual();
    }

    @Then("The config multilingual is activate")
    public void config_activate_multilingual() {
        instanceOfWeb(AdminConfigurationPage.class).verifyActivateMultilingual();
    }


}
