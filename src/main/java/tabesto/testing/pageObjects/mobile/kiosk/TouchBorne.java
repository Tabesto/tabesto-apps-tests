package tabesto.testing.pageObjects.mobile.kiosk;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tabesto.testing.pageObjects.mobile.BaseMobile;


public class TouchBorne extends BaseMobile {

    // @AndroidFindAll(value = { @AndroidBy(id = "")}, priority = 0)
   // private List<WebElement> listImages;
    @AndroidFindBy(id = "textview_start_tabesto_number")
    private WebElement tabestoNumberTextview;
    @AndroidFindBy(id = "textview_start_table_name")
    private WebElement tableNameTextview;
    @FindBy(id = "com.tabesto.kiosk.debug:id/imageview_slider_item_picture")
    private WebElement touchScreenButton;
    @FindBy(xpath = "//android.widget.Toast")
    private WebElement toast;



    public boolean verifyVisibleElementsOnScreen() {
        return ( tabestoNumberTextview.isDisplayed() && tableNameTextview.isDisplayed() && touchScreenButton.isDisplayed());
    }

    public void touchScreen() {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        touchScreenButton.click();
    }
    public boolean touchScreenDisplayed() {
        return touchScreenButton.isDisplayed();
    }

    public String getToast() {
        return toast.getText();
    }
}
