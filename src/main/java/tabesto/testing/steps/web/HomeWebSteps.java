package tabesto.testing.steps.web;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import tabesto.testing.pageObjects.web.AdminTablettesPage;
import tabesto.testing.pageObjects.web.LoginWebPage;
import tabesto.testing.model.DataSet;

import static tabesto.testing.pageObjects.web.BaseWebPage.instanceOfWeb;

public class HomeWebSteps extends BaseWebSteps{

    @When("User go to url {string}")
    public void go_to_url(String url) {
        instanceOfWeb(LoginWebPage.class).goToUrl(url);
    }

    @When("User will be redirect to {string}")
    public void user_will_be_redirect_to(String url) {
        if(url.contains("tablet")) {
            DataSet.getInstance().setNumTable(instanceOfWeb(AdminTablettesPage.class).getLastNumTerminal());
        }
        Assert.assertTrue(instanceOfWeb(LoginWebPage.class).waitUrlContains(url));
    }

    @Then("No cart exist in tab {string}")
    public void no_cart_exist_in_tab(String tabTitle) {
    }

    @When("Admin-user logout")
    @When("New-user logout")
    public void adminUser_logout() {
        instanceOfWeb(LoginWebPage.class).logout();
    }

    @When("Admin-user connect with {string} credentials")
    public void adminUser_connect(String newUser) {
        instanceOfWeb(LoginWebPage.class).login("", "");
    }
}
