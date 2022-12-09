package tabesto.testing.steps.mobile.kiosk;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import tabesto.testing.pageObjects.mobile.kiosk.HomeKiosk;
import tabesto.testing.model.DataSet;
import tabesto.testing.steps.mobile.SharedMobileSteps;

import java.util.Date;
import java.util.Locale;

public class HomeScreenKioskSteps extends SharedMobileSteps {

    @Given("Home screen of kiosk app is displayed")
    public void home_screen_kiosk_app_is_displayed() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("User see in the header of screen {string} N°,{string} N° and {string}")
    public void user_see_in_the_header_of_screen(String tabesto, String table, String userName) {
        new HomeKiosk().getListPicture();
       Assert.assertTrue( new HomeKiosk().getTabestoName().toUpperCase(Locale.ROOT).contains(tabesto));
       Assert.assertTrue( new HomeKiosk().getTerminalName().toUpperCase(Locale.ROOT).contains(table));
       Assert.assertTrue( new HomeKiosk().getUserName().contains(userName));
    }

    @Then("User see at the top right corner of screen {string}")
    public void user_see_in_the_top_right_of_screen(String price) {
            //Assert.assertEquals( instanceOf(HomeKiosk.class).getPrice(), FileReaderManager.getInstance().getJsonReader().getProductData().get(price));


    }

    @Then("User see at the top left corner of screen {string}")
    public void user_see_in_the_top_left_of_screen(String type) {
            //Assert.assertEquals("MA COMMANDE " +  instanceOf(HomeKiosk.class).getLocation(), "MA COMMANDE "+ FileReaderManager.getInstance().getJsonReader().getProductData().get(type));

    }

    @Then("All categories in back-office are displayed on screen")
    public void all_categories_in_back_office_displayed() {
        Assert.assertEquals( new HomeKiosk().getListMenuItemTitle(), DataSet.getInstance().getListCategories());
    }

    @When("User click on \"abondonner\" button")
    public void user_click_on_quit_button() {
        new HomeKiosk().clickOnCancelButton();
    }

    @When("User click on \"valider\" button")
    public void user_click_on_validate_button() {
        new HomeKiosk().clickOnOKButton();
    }

    @When("Menu bar is displayed")
    public void menu_bar_displayed() {
        Assert.assertTrue( new HomeKiosk().verifyPresentBarMenu());
    }

//    @When("User click on tab {string}")
//    public void user_click_on_tab(String tabTitle) {
//        new HomeKiosk().clickOnBarMenuItem(tabTitle);
//    }

    @When("User close all opened tab")
    public void user_close_all_opened_tab() {
        new HomeKiosk().closeAllTab();
    }

    @Then("All categories tabs are opened")
    public void all_categories_tabs_are_opened() {
        new HomeKiosk().verifyDisplayedProduct();
    }

    @Then("No product exist")
    public void no_product_exist() {
        Assert.assertTrue( new HomeKiosk().verifyNotVisibleMenuItem());
    }

    @Then("Category {string} with product {string} is present")
    public void category_product_is_present(String category, String product) {
        Assert.assertTrue( new HomeKiosk().isExistInListProductItemTitle(product));
        Assert.assertTrue( new HomeKiosk().verifyVisibleCategory(category));
    }

    @Then("Product {string} is present")
    public void product_is_present(String category) {
        //textview_main_product_item_title
        Assert.assertTrue( new HomeKiosk().verifyNotVisibleMenuItem(), category + "not in" +  new HomeKiosk().getListMenuItemTitle().toString());
    }

    @Then("Category {string} is not present")
    public void category_is_not_present(String category) {
       Assert.assertFalse( new HomeKiosk().getListProductItemTitle().contains(category));
    }

    @Then("Only category {string} exist")
    public void only_category_exist(String category) {
        if(new Date().compareTo(DataSet.getInstance().getToday()) >= 0) {
            Assert.assertTrue( new HomeKiosk().getListProductItemTitle().size() == 1);
            Assert.assertTrue( new HomeKiosk().getListProductItemTitle().contains(category));
        }

    }

//    @When("User select category {string}")
//    public void user_select_category(String category) {
//        category = Arrays.stream(category.split(":")).collect(toList()).get(1);
//        Assert.assertTrue(new HomeKiosk().selectCategory(FileReaderManager.getInstance().getJsonReader().getProductData().
//                get(1).getCategory().get(Integer.parseInt(category)).title));
//    }


    @When("User select category {string}")
    public void user_select_category(String category) {
        Assert.assertTrue(new HomeKiosk().selectCategory(category));
    }



    @When("User exit session")
    public void user_exit_session() {
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(new HomeKiosk().exitSession());

    }

    @Then("{int} image on start screen")
    public void imageOnStartScreen(int nbreScreen) {
    }
}
