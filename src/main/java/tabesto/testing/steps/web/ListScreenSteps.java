package tabesto.testing.steps.web;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import tabesto.testing.pageObjects.web.*;

import static tabesto.testing.pageObjects.web.BaseWebPage.instanceOfWeb;

public class ListScreenSteps extends BaseWebSteps {



    @Then("{string} cart exist in tab start")
    public void cart_exist_in_tab_start(String numberOfCart) {
      //  Assert.assertTrue(listScreenPage.verifyNumberOfStartScreen().contains("(" + (numberOfCart.equals("No") ? 0 : Integer.parseInt(numberOfCart)) + ")"));
    }

    @When("User click on icon delete screen position {int}")
    public void user_click_on_icon_delete_screen_position(int index) {
     int numberScreen = instanceOfWeb(ListScreenPage.class).getCountScreen();
     instanceOfWeb(ListScreenPage.class).deleteScreen(index);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(numberScreen == instanceOfWeb(ListScreenPage.class).getCountScreen() + 1);
    }
}
