package tabesto.testing.pageObjects.mobile.kiosk;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tabesto.testing.pageObjects.mobile.BaseMobile;

public class LocationChoice extends BaseMobile {

    @FindBy(id = "imageview_close_button_icon")
    private WebElement retourButton;
    @FindBy(id = "textview_main_info_top_bar_user_name")
    private WebElement firstnameTextview;
    @FindBy(id = "button_location_choice_on_site")
    private WebElement onSiteButton;
    @FindBy(id = "button_location_choice_take_away")
    private WebElement takeAwayButton;

    public String verifyTextView() {
        return firstnameTextview.getText().replace(",","");
    }
    public IdentificationBorne clickOnSiteButton(){
        onSiteButton.click();
        return new IdentificationBorne();
    }
    public IdentificationBorne clickOnTakeAwayButton(){
        takeAwayButton.click();
        return new IdentificationBorne();
    }

}
