package tabesto.testing.pageObjects.web;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tabesto.testing.model.DataSet;

import java.util.List;

public class AdminTablettesPage extends BaseWebPage {

    @FindBy(css = "tbody tr")
    private List<WebElement> allDevices;
    @FindBy(xpath = "//select[@id='user_defaultTable']")
    private WebElement numTable;
    @FindBy(id = "top-navigation-form-save-button")
    private WebElement saveButton;
    @FindBy(xpath = "//*[@id='configEditType_DISPLAY_TOP_BAR_0']//parent::*")
    private  WebElement displayBarRadio;

    public void selectTab(String nameTab) {
       /* Actions actions = new Actions();
        allDevices.forEach(row -> {
            if (row.findElements(By.tagName("td")).get(2).getText().equals(nameTab)){
                actions.doubleClick(row).perform();
            }
        });*/
    }

    public void updateTabletDetails(String updateValue) {
        numTable.sendKeys(updateValue);
        numTable.sendKeys(Keys.chord(Keys.ENTER));
    }

    public void clickOnSaveButton() {
        saveButton.click();
    }
    public void activateBarMenu(){
        if(!displayBarRadio.isSelected()) {
            displayBarRadio.click();
        }
    }

    public AdminTablettesPage(WebDriver webDriver) {
        //super(webDriver);
    }

    public String getLastNumTerminal(){
        WebElement last = allDevices.get(allDevices.size()-1).findElements(By.tagName("td")).get(1);
        return last.getText();
    }
    public void configureBorneInBackOffice() {
        selectTab(DataSet.getInstance().getNumTable());
        switchWindows(1);
        waitUrlContains("tablet/edit");
        updateTabletDetails("defaultTab");
        clickOnSaveButton();
        waitUrlContains("/tablet/list");

    }
}
