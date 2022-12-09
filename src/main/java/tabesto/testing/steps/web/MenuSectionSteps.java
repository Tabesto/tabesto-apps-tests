package tabesto.testing.steps.web;

import io.cucumber.java.en.When;
import tabesto.testing.pageObjects.web.*;

import static tabesto.testing.pageObjects.web.BaseWebPage.instanceOfWeb;

public class MenuSectionSteps extends  BaseWebSteps{


    @When("User click on menuItem {string}")
    @When("User click on submenu {string}")
    @When("Admin-user click on submenu {string}")
    @When("Admin-user click on menuItem {string}")
    public void user_click_on_menuItem(String menuItem) {
        instanceOfWeb(MenuNavigationWebPage.class).clickOnMenu(menuItem);
    }

}
