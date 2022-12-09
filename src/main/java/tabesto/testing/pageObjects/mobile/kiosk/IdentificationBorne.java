package tabesto.testing.pageObjects.mobile.kiosk;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tabesto.testing.pageObjects.mobile.BaseMobile;

public class IdentificationBorne extends BaseMobile {


    @FindBy(id = "form_edit_text_identification_name")
    private WebElement nameInput;
    @FindBy(id = "keyboardview_identification_name")
    private WebElement keyboardView;
    @FindBy(id = "button_identification_name_cancel")
    private WebElement cancelNameButton;
    @FindBy(id = "button_identification_name_confirm")
    private WebElement validateButton;

    public IdentificationBorne setFirstName(String firstName) {
        nameInput.sendKeys(firstName);
        return this;
    }

    public IdentificationBorne clickOnValidateButton() {
        validateButton.click();
        return this;
    }

}
