package tabesto.testing.steps.web;

import io.cucumber.java.en.When;
import tabesto.testing.pageObjects.web.NewTablePage;

import static tabesto.testing.pageObjects.web.BaseWebPage.instanceOfWeb;

public class TableSteps extends BaseWebSteps{

    @When("User click on button \"CRÉER NOUVELLE TABLE\"")
    public void user_click_ok_button_create() {
        instanceOfWeb(NewTablePage.class).clickOnCreateTable();
    }

    @When("User create new {string}")
    public void user_create_new_table(String typeTable) {
        instanceOfWeb(NewTablePage.class).setNumTable("4");
        instanceOfWeb(NewTablePage.class).setNumSalle("1");
        instanceOfWeb(NewTablePage.class).setNumCouvert("3");
        instanceOfWeb(NewTablePage.class).selectType(typeTable);
        instanceOfWeb(NewTablePage.class).saveTable();
        instanceOfWeb(NewTablePage.class).waitUrlContains("table/list");
    }
}
