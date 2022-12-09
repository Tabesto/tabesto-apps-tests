package tabesto.testing.steps.mobile.kiosk;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import tabesto.testing.pageObjects.mobile.kiosk.OrderBorne;

import java.io.IOException;
import java.util.Locale;


public class OrderScreenSteps{


    @When("User go to the cart")
    public void user_click_on_ma_commande() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new OrderBorne().clickOnMaCommand();
    }

    @When("User click on \"LA CARTE\"")
    public void user_click_on_la_carte() {
        new OrderBorne().clickOnLaCarte();
    }
    @Then("{string} is displayed")
    public void message_is_displayed(String message) {
       Assert.assertEquals(new OrderBorne().getMessageOnScreen(), message);
    }

    @When("User click on choice counter payment")
    public void user_click_on_counter_payment() {
        new OrderBorne().clickOnCounterPayment();
    }
    @When("User click on choice CB payment")
    public void user_click_on_cb_payment() throws IOException {
        new OrderBorne().clickOnCBPayment();

    }

    @Then("Button \"REVENIR AU MENU\" is present")
    public void button_is_present() {
        Assert.assertTrue(new OrderBorne().isDisplayedBackToCart());
    }

    @Then("status {string} is displayed with success")
    public void textIsDisplayed(String message) {Assert.assertEquals(new OrderBorne().getStatusPrint(), message);}

    @Then("{string} is displayed with success")
    public void paymentStatus(String message) {Assert.assertEquals(new OrderBorne().getStatusCB(), message);}

    @Then("The order contains product {string}")
    public void the_order_contains_product(String product) {
        Assert.assertTrue(new OrderBorne().getProduct().contains(product.toLowerCase(Locale.ROOT)));
    }

    @When("User click on \"confirmer et payer\"")
    public void user_click_on_confirmer_payer() {
        new OrderBorne().confirmerPayment();
    }
    @Then("{string} is displayed!")
    public void message(String message) {
        Assert.assertEquals(new OrderBorne().getTitle(), message);
    }
    @Then("{string} is displayed on screen order")
    public void messagePaymentCompton(String message) {
        Assert.assertEquals(new OrderBorne().getMessageConfirmationPayment(), message);
    }
    @Then("The order contains products")
    public void the_order_contains_products() {
            //Assert.assertTrue(instanceOf(OrderBorne.class).getProduct().contains(FileReaderManager.getInstance().getJsonReader().getProductData().get("product").toString()));


    }
    @Then("The order contains all products")
    public void the_order_contains_all_products() throws InterruptedException {
        Thread.sleep(50000);
       new OrderBorne().getProductsFromCart();
    }

    }
