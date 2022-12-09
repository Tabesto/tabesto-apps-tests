package tabesto.testing.steps.web;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tabesto.testing.pageObjects.web.LoginWebPage;
import tabesto.testing.pageObjects.web.UserPage;

import static tabesto.testing.pageObjects.web.BaseWebPage.instanceOfWeb;

public class UserWebSteps extends BaseWebSteps{

    @When("Admin-user create a new-user")
    public void adminUser_create_user() {
        instanceOfWeb(UserPage.class).createNewUser();
    }

    @When("Admin-user activate account for new-user")
    public void adminUser_activate_account() {
        instanceOfWeb(UserPage.class).activateAccount();
    }

    @When("Admin-user connect to server {string}")
    public void admin_user_connect_server(String serverUrl) {
        instanceOfWeb(LoginWebPage.class).goToUrl(serverUrl);
        instanceOfWeb(LoginWebPage.class).login("admin", "");
    }

    @When("Admin-user add {string} to the new-user")
    public void adminUser_activate_account(String roles) {
        instanceOfWeb(UserPage.class).addRole(roles);
    }
    @When("Admin-user change password for new-user")
    public void adminUser_change_password() {
        instanceOfWeb(UserPage.class).changePassword();
    }

    @When("Admin-user disable account for new-user")
    public void adminUser_disable_account() {
        instanceOfWeb(UserPage.class).activateAccount();
    }

    @When("Admin-user delete account for new-user")
    public void adminUser_delete_account() {
        instanceOfWeb(UserPage.class).disableAccount();
    }

    @When("User login as admin")
    public void user_login_as_admin() {
        instanceOfWeb(LoginWebPage.class).login("admin", "HOH026UW4OY49054GZWCJGDZ");
    }

    @Then("Message Account is disabled appears")
    public void message_account_disbled() {
    }
    @Then("Message invalid credentials appears")
    public void message_invalid_credentials() {
    }

}
