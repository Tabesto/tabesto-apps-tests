package tabesto.testing.pageObjects.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewScreenPage extends BaseWebPage {

    @FindBy(xpath = "//button[@data-id='main_menu_item_menu']//span[@class='filter-option pull-left'][normalize-space()='Aucun produit sélectionné']")
    private WebElement selectCart;
    @FindBy(id = "main_menu_item_title")
    private WebElement titleCart;
    @FindBy(xpath = "//button[@data-id='main_menu_item_location']")
    private WebElement positionCart;
    @FindBy(id = "fileupload")
    private WebElement uploadImage;
    @FindBy(id = "top-navigation-form-save-button")
    private WebElement saveScreen;


    public void selectCart(String cartTitle) {
       wait.until(ExpectedConditions.elementToBeClickable(selectCart));
       selectCart.click();
      // webDriver.findElement(By.xpath("//span[normalize-space()='" + cartTitle + "']")).click();
    }

    public void setTitleCart( String titleCart){
        this.titleCart.sendKeys(titleCart);
    }

    public void uploadImage(String imagePath) {
        uploadImage.sendKeys("C:\\Users\\rabaaa\\Downloads\\téléchargement.jfif");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void verifyPosition(){
    }

    public void clickOnSaveScreen() {
        wait.until(ExpectedConditions.elementToBeClickable(saveScreen));
        saveScreen.click();
    }

}
