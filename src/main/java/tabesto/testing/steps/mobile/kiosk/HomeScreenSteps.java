package tabesto.testing.steps.mobile.kiosk;

import tabesto.testing.enums.CommandType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tabesto.testing.steps.mobile.SharedMobileSteps;
import tabesto.testing.utils.generator.FakerData;
import org.testng.Assert;
import tabesto.testing.pageObjects.mobile.kiosk.HomeKiosk;
import tabesto.testing.pageObjects.mobile.kiosk.IdentificationBorne;
import tabesto.testing.pageObjects.mobile.kiosk.LocationChoice;
import tabesto.testing.pageObjects.mobile.kiosk.TouchBorne;
import tabesto.testing.utils.HelpersMethod;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static tabesto.testing.enums.CommandType.ONSITE;
import static java.util.stream.Collectors.toList;

public class HomeScreenSteps  extends SharedMobileSteps {
    HelpersMethod utils = new HelpersMethod();

    @Given("User touch \"TOUCHER POUR COMMENCER\"")
    public void user_touch_screen(){
        new TouchBorne().touchScreen();
    }

    @When("User create a new session {string}")
    public void user_create_a_new_session(String commandType) {
        if (CommandType.valueOf(commandType) == ONSITE){
            utils.log().info("User has chose type Onsite");
            new LocationChoice().clickOnSiteButton().setFirstName(FakerData.generateRandomUserName()).
                clickOnValidateButton();
        }else
        {
            new LocationChoice().clickOnTakeAwayButton().setFirstName(FakerData.generateRandomUserName()).
                    clickOnValidateButton();
        }
    }

    @When("User click on validate button")
    public void user_click_on_validate() {
        new IdentificationBorne().clickOnValidateButton();
    }

    @Then("{string} is displayed on choice screen")
    public void _is_displayed_on_screen(String msg) {
        Assert.assertEquals(new LocationChoice().verifyTextView(), msg + ",");
    }

    @When("User choose type of command {string}")
    public void user_choose_location_away(String location){
        location = Arrays.stream(location.split(":")).collect(toList()).get(1);
        System.out.println("LOCATION"+jsonDataReader.getData().get(1).category.get(Integer.parseInt(location)).getLocation());
        if(jsonDataReader.getData().get(1).category.get(Integer.parseInt(location)).getLocation().equals("SUR PLACE"))
            {
                new LocationChoice().clickOnSiteButton() ;
            }
        else {
                new LocationChoice().clickOnTakeAwayButton();
             }
    }

    @Then("startScreen is displayed")
    public void startScreenIsDisplayed() {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(new TouchBorne().touchScreenDisplayed());
    }

    @When("User set numero {int}")
    public void userSetNumero(int numero) {
    }



    @When("Wifi is down then then error message is displayed")
    public void wifiIsDownThenTheIsDisplayed() throws IOException {
        List<String> messages = Arrays.asList("Connexion perdue", "Lost connection","Conexión perdida",
                "Verbindung verloren","Connessione persa","Ligação perdida","Verloren verbinding","Conexió perduda");
        Assert.assertTrue(messages.contains(new HomeKiosk().getWifiError()));
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
