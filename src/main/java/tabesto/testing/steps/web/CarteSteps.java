package tabesto.testing.steps.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import tabesto.testing.model.DataSet;
import tabesto.testing.pageObjects.web.*;

import java.util.Date;

import static tabesto.testing.pageObjects.web.BaseWebPage.instanceOfWeb;

public class CarteSteps extends BaseWebSteps{


    @When("User add new food category {string}")
    public void user_add_new_food_category(String categoryName) {
        instanceOfWeb(CategoriesPage.class).createNewCategory();
        instanceOfWeb(CategoriesPage.class).selectCart("Carte par défaut ( Sur place, A emporter )");
        instanceOfWeb(CategoriesPage.class).setNoformulaSeq();
        instanceOfWeb(CategoriesPage.class).setFoodAsTypeCategory();
        instanceOfWeb(CategoriesPage.class).setNameCategoryInput(categoryName);
        instanceOfWeb(CategoriesPage.class).saveCategory();
        instanceOfWeb(CategoriesPage.class).waitUrlContains("category/list");
    }

    @When("User add new drink category {string}")
    public void user_add_new_drink(String drink) {
        instanceOfWeb(CategoriesPage.class).createNewCategory();
        instanceOfWeb(CategoriesPage.class).selectCart("Carte par défaut ( Sur place, A emporter )");
        instanceOfWeb(CategoriesPage.class).setNoformulaSeq();
        instanceOfWeb(CategoriesPage.class).setDrinkAsTypeCategory();
        instanceOfWeb(CategoriesPage.class).setNameCategoryInput(drink);
        instanceOfWeb(CategoriesPage.class).saveCategory();
        instanceOfWeb(CategoriesPage.class).waitUrlContains("category/list");
    }

    @When("User delete category {string}")
    public void user_delete_category(String categoryName){
        instanceOfWeb(CategoriesPage.class).deleteCategory(categoryName);
        instanceOfWeb(CategoriesPage.class).validateDelete();
    }

    @Given("User is on categories page")
    public void user_is_on_categories_page(){
        instanceOfWeb(LoginWebPage.class).goToUrl("https://srv-0002.uat.tabesto.com/");
        instanceOfWeb(LoginWebPage.class).login("admin", "5NMMbMaM0zi0AyBfUv");
        instanceOfWeb(MenuNavigationWebPage.class).clickOnMenu("Catégories");
        DataSet.getInstance().setListCategories(instanceOfWeb(CategoriesPage.class).getAllCategories());
    }

    @When("User click on \"Les boissons\"")
    public void user_click_on_boissons(){
        instanceOfWeb(CategoriesPage.class).clickOnTabDrink();
    }

    @When("User click on icon duplicate {string}")
    public void user_click_on_icon_duplicate(String nameMenu) {
        instanceOfWeb(CartePage.class).clickOnMenu(nameMenu);
    }

    @When("User search category {string}")
    public void userSearchCategory(String category) {
        instanceOfWeb(CartePage.class).searchCategory(category);
    }

    @When("User select group {string}")
    public void userSelectGroup(String group) {
        instanceOfWeb(CartePage.class).selectCategory(group);
    }

    @When("User click on duplicate button")
    public void userClickOnDuplicateButton() {
        instanceOfWeb(CartePage.class).duplicateMenu();
    }

    @When("User set {string} as name")
    public void userSetAsName(String name) {
        instanceOfWeb(CartePage.class).setNameMenu(name);
    }

    @When("User set {string} as description")
    public void userSetAsDescription(String description) {
        instanceOfWeb(CartePage.class).setMenuDescription(description);
    }

    @And("User choose personalize period")
    public void userChoosePersonalizePeriod() {
        instanceOfWeb(CartePage.class).activatePersonalizePeriod();
    }

    @And("User set start hour and duration as actually datetime")
    public void user_set_start_hour_duration_as_actually() {
        DataSet.getInstance().setToday(new Date(new Date().getTime() - 10 * 60 * 1000));
        instanceOfWeb(CartePage.class).setHourAndDuration(DataSet.getInstance().getToday().getHours()+ "", DataSet.getInstance().getToday().getMinutes() + "", "3");
    }

    @And("User set start hour and duration for second menu")
    public void user_set_start_hour_duration() {
        DataSet.getInstance().setToday(new Date(new Date().getTime() - 2 * 60 * 1000));
        instanceOfWeb(CartePage.class).setHourAndDuration(DataSet.getInstance().getToday().getHours()+ "", (DataSet.getInstance().getToday().getMinutes()  ) + "", "13");
    }

    @And("User double click on {string}")
    public void user_double_click_on_menu(String menu) {
        instanceOfWeb(CartePage.class).doubleClickOnMenu(menu);
    }

    @And("User wait to sync")
    public void userWaitToSync() {
    }
}
