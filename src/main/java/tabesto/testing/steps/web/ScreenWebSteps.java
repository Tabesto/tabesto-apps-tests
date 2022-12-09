package tabesto.testing.steps.web;

import io.cucumber.java.en.When;
import tabesto.testing.pageObjects.web.ListScreenPage;
import tabesto.testing.pageObjects.web.NewScreenPage;

import static tabesto.testing.pageObjects.web.BaseWebPage.instanceOfWeb;

public class ScreenWebSteps extends BaseWebSteps{


    @When("User click on button \"CRÉER UN ÉCRAN D'ACCUEIL\"")
    public void user_click_on_create_screen() {
        instanceOfWeb(ListScreenPage.class).clickOnAddNewScreen();
    }

    @When("User select cart {string}")
    public void user_select_cart(String cartTitle) {
        instanceOfWeb(NewScreenPage.class).selectCart(cartTitle);
    }

    @When("User set title {string}")
    public void user_title_cart(String cartTitle) {
        instanceOfWeb(NewScreenPage.class).setTitleCart(cartTitle);
    }

    @When("User upload image {string}")
    public void user_upload_image(String pathImage) {
        instanceOfWeb(NewScreenPage.class).uploadImage(pathImage);
    }

    @When("User click on button \"SAUVEGARDER\"")
    public void user_click_on_save_button() {
        instanceOfWeb(NewScreenPage.class).clickOnSaveScreen();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
