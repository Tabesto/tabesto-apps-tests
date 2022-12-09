package tabesto.testing.steps.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tabesto.testing.pageObjects.web.MenuNavigationWebPage;
import tabesto.testing.pageObjects.web.NewScreenPage;
import tabesto.testing.pageObjects.web.ProductPage;

import static tabesto.testing.pageObjects.web.BaseWebPage.instanceOfWeb;

public class ProductSteps {


    @When("Admin-user add new food product {string} for category {string}")
    @When("New-user add new food product {string} for category {string}")
    public void user_add_new_product(String productName, String categoryName) {
        instanceOfWeb(MenuNavigationWebPage.class).clickOnMenu("Liste des Produits");
        instanceOfWeb(ProductPage.class).createNewProduct();
        instanceOfWeb(ProductPage.class).setTypeFoodProduct();
        instanceOfWeb(ProductPage.class).setFormulaAndMenu();
        instanceOfWeb(ProductPage.class).setNameProductInput(productName);

        instanceOfWeb(ProductPage.class).setSelectCategory(categoryName);
        instanceOfWeb(ProductPage.class).setPriceInput("5");
        instanceOfWeb(NewScreenPage.class).uploadImage("");
        instanceOfWeb(ProductPage.class).saveProduct();
        instanceOfWeb(ProductPage.class).waitUrlContains("food/list");
    }

    @When("User add new drink product {string} for category {string}")
    public void user_add_new_drink(String productName, String categoryName) {
        instanceOfWeb(MenuNavigationWebPage.class).clickOnMenu("Liste des Produits");
        instanceOfWeb(ProductPage.class).createNewProduct();
        instanceOfWeb(ProductPage.class).setTypeDrinkProduct();
        instanceOfWeb(ProductPage.class).setJustFormula();
        instanceOfWeb(ProductPage.class).setNameProductInput(productName);
        instanceOfWeb(ProductPage.class).setSelectCategory(categoryName);
        instanceOfWeb(NewScreenPage.class).uploadImage("");
        instanceOfWeb(ProductPage.class).saveProduct();
        instanceOfWeb(ProductPage.class).waitUrlContains("food/list");
    }

    @Then("Product {string} is {string} in the list of products")
    public void product_is_present(String productName, String isPresent) {
        //instanceOfWeb(ProductPage.class).verifyPresentOfProduct(productName, isPresent.equals("present") ? true:false);
    }

    @And("User click on ajouter la formule button")
    public void user_click_on_add_formula_button() {
    }

    @When("User select first choice {string}")
    public void user_select_first_choice(String product) {

    }

    @And("User add {string}")
    public void user_add_option(String option) {
    }

    @And("User click on ajouter button")
    public void user_click_on_add_button() {
    }

    @Then("User see {string} as first choice")
    public void user_see_first_choice(String option) {
    }

    @Then("User see {string} as second choice")
    public void user_see_second_choice(String option){
    }

    @When("User select third choice {string}")
    public void user_select_third_choice(String option) {
    }

    @When("User select fourth choice {string}")
    public void user_select_fourth_choice(String option) {
    }

    @Then("The order contains {string} with option {string}")
    public void the_order_contains_category_option(String category, String option) {
    }

    @And("User choose convert product to menu {string}")
    public void user_choose_convert_product_to_menu(String menu) {
    }

    @When("User click on Annuler button for second choice")
    public void user_click_on_cancel_button_second_choice() {
    }

    @And("User validate annuler {string}")
    public void user_validate_cancel(String menu) {
    }

    @Then("The section of the second choose appear")
    public void the_section_of_the_second_choose_appear() {
    }

    @And("User click on add Grilled Cheese")
    public void user_click_on_add_product() {
    }

    @And("User select {string}")
    public void userSelectBacon(String option) {
    }

    @And("User click on valider button")
    public void user_click_on_validate_button() {
    }

    @Then("The order contains {string} with option {string} and {string}")
    public void theOrderContainsWithOptionAnd(String arg0, String arg1, String arg2) {
    }

    @And("User set quantity as {string}")
    public void user_set_quantity(String quantity) {
    }

    @Then("The order contains {string}")
    public void theOrderContains(String arg0) {
    }

    @And("User click on his order {string}")
    public void user_click_on_his_order(String orderName) {
    }

    @And("User add comment {string}")
    public void user_add_comment(String comment) {
    }

    @And("User click on {string} button")
    public void userClickOnButton(String actionBtn) {
    }

}
