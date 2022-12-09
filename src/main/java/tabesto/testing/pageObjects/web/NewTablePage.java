package tabesto.testing.pageObjects.web;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewTablePage extends BaseWebPage{
    @FindBy(xpath = "//input[@id='form_number']")
    private WebElement numTable;
    @FindBy(xpath = "//button[@data-id='form_room']")
    private WebElement numSalle;
    @FindBy(xpath = "//button[@data-id='form_type']//span[@class='filter-option pull-left'][normalize-space()='Aucun produit sélectionné']")
    private WebElement typeTable;
    @FindBy(xpath = "//input[@id='form_default_customers']")
    private WebElement numCouvert;
    @FindBy(xpath ="//input[@id='form_printerAddress']")
    private WebElement printerAddressInput;
    @FindBy(xpath ="//input[@id='form_tpeIpAddress']")
    private WebElement tpeIpAddressInput;
    @FindBy(xpath ="//input[@id='form_posAuthToken']")
    private WebElement posAuthTokenInput;
    @FindBy(xpath = "//a[normalize-space()='SAUVEGARDER']")
    private WebElement saveButton;

    @FindBy(xpath ="//a[normalize-space()='CRÉER NOUVELLE TABLE']")
    private WebElement createButton;

    public void setNumTable(String num) { numTable.sendKeys(num);}
    public void clickOnCreateTable() { createButton.click();}
    public void setNumSalle(String num){
        numSalle.sendKeys(num);
        numSalle.sendKeys(Keys.chord(Keys.ENTER));
    }
    public void setNumCouvert(String num){
        numCouvert.sendKeys(num);
    }
    public void selectType(String type){
        typeTable.click();
        //webDriver.findElement(By.xpath("//span[normalize-space()='" + type + "']")).click();
    }
    public void saveTable() { saveButton.click();}

    public NewTablePage(WebDriver webDriver) {
        //super(webDriver);
    }
}
