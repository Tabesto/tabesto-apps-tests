package tabesto.testing.steps.mobile.kiosk;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tabesto.testing.config.Settings;
import tabesto.testing.model.MealSeq;
import org.testng.Assert;
import tabesto.testing.pageObjects.mobile.kiosk.Product;
import tabesto.testing.model.DataSet;
import tabesto.testing.steps.mobile.SharedMobileSteps;

import java.io.IOException;
import java.util.*;

import static java.util.stream.Collectors.toList;


public class ProductScreenSteps extends SharedMobileSteps {

    @When("User choose the {string} product in {string}")
    public void user_choose_food_product(String product, String category) throws InterruptedException {
        if (Boolean.getBoolean(Settings.getInstance().getTestDataResourcesPath())){
            category = Arrays.stream(category.split(":")).collect(toList()).get(1);
            Random rand = new Random();
            List<String> products = jsonDataReader.getData().get(1).getCategory().get(Integer.parseInt(category)).products;
            int randomIndex = rand.nextInt(products.size());
            Assert.assertTrue((Boolean) new Product().selectProduct(products.get(randomIndex), false,false).get("FOUND"));
        }else {
            if (product.contains("NewProduct")){
                new Product().selectProduct(DataSet.getInstance().getProductsCreated().get(0), false,false);
            }else {
                new Product().selectProduct(product, false,false);
            }
        }
    }

    @When("User choose a food product in MealSequence {string}")
    public void user_choose_food_product_from_mealSequence(String category) throws InterruptedException {
        category = Arrays.stream(category.split(":")).collect(toList()).get(1);
        Random rand = new Random();
        List<MealSeq>products = jsonDataReader.getData().
                get(1).getCategory().get(Integer.parseInt(category)).mealSeqList;
        int randomIndex = rand.nextInt(products.size());
        int choicesNumber = jsonDataReader.getData().get(1)
                .getCategory().get(Integer.parseInt(category)).mealSeqList.get(0).choicesNumber;
        String MealSeqName = jsonDataReader.getData().get(1).
                getCategory().get(Integer.parseInt(category)).mealSeqList.get(0).name;
        Assert.assertTrue((Boolean) new Product().selectProduct(MealSeqName, false,false).get("FOUND"));

        for (int i=1; i <= choicesNumber ; i++){
            Assert.assertTrue((Boolean) new Product().selectProduct(products.get(0).getChoice_id(i).get(randomIndex), false,false).get("FOUND"));
            select_options();
            user_click_on_ajouter_button();
        }
        user_click_on_ajouter_button();

    }

    @Then("Product screen details is displayed")
    public void product_screen_details() {
        Assert.assertNotEquals(new Product().getNameOfProduct(),"");
        new Product().getListOptionsItemTitle();
    }
    @Then("Product quantity is {string}")
    public void product_quantity(String quantity) {
        Assert.assertEquals(new Product().getQuantity(), quantity);
    }

    @When("User select options")
    public void select_options() throws InterruptedException {
        new Product().selectOptions();
    }

    @When("User add product to the cart")
    public void user_click_on_ajouter_button() {
        new Product().addProduct().isDisplayedNonMerci();
    }

    @When("User ignore productSuggestion")
    public void user_click_on_non_merci_button() {
        new Product().isDisplayedNonMerci();

    }

    @Then("Warning {string} is displayed")
    public void warningIsDisplayed(String message) {
    }

    @When("User select second choice {string}")
    public void userSelectSecondChoice(String secondChoice) {
    }
    @When("User select options {string}")
    public void userSelectOptions(String options){
        String result = String.join(",", new Product().getAllOptions());

    }
    @When("User click on button retour")
    public void user_click_on_retour_button() {
        new Product().retourButton();
    }

    @Then("User seen all as choices")
    public void user_see_all_choice() {
        System.out.println(DataSet.getInstance().getMap());
        Map<String,String> list = new Product().checkProductAndOptionsOnAllChoice();
        System.out.println(list);
        Assert.assertTrue(DataSet.getInstance().getMap().entrySet().stream()
                .allMatch(e -> e.getValue().equals(list.get(e.getKey()))));

    }

    @Then("product is marked as unavailable")
    public void productIsMarkedAsUnavailable() throws InterruptedException {
        Assert.assertTrue(new Product().
                searchProductInfoOnListCategory(DataSet.getInstance().getProductsCreated().get(0)));
    }

    @Then("Update Popin is displayed and product is marked as unavailable")
    public void updatePopinIsDisplayedAndProductIsMarkedAsUnavailable() throws IOException, InterruptedException {
        Assert.assertTrue(new Product().verifyDisplayOfPopinAndCheckAvailabilityOfProduct());
    }
}
