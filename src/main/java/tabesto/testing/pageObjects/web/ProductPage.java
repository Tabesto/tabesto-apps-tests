package tabesto.testing.pageObjects.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BaseWebPage{
    @FindBy(id = "top-navigation-form-save-button")
    private WebElement createProductButton;
    @FindBy(xpath = "//button[@data-id='food_sectionsDirect']//span[@class='filter-option pull-left'][normalize-space()='Aucun produit sélectionné']")
    private WebElement selectCategory;
    @FindBy(xpath = "//*[@id='food_type_1']//parent::*")
    private WebElement typeFoodProduct;
    @FindBy(xpath = "//*[@id='food_menuOnly_0']//parent::*")
    private WebElement justFormula;
    @FindBy(xpath = "//*[@id='food_menuOnly_1']//parent::*")
    private WebElement formulaAndMenu;
    @FindBy(xpath = "//*[@id='food_type_2']//parent::*")
    private WebElement typeDrinkProduct;
    @FindBy(xpath = "//input[@id='food_name']")
    private WebElement nameProductInput;
    @FindBy(id = "food_price")
    private WebElement priceInput;
    @FindBy(xpath = "//a[normalize-space()='SAUVEGARDER']")
    private WebElement saveButton;

    public void setTypeFoodProduct(){
        typeFoodProduct.click();
    }
    public void setTypeDrinkProduct() {
        typeDrinkProduct.click();
    }
    public void setNameProductInput(String productName) {
        nameProductInput.sendKeys(productName);
    }
    public void setJustFormula(){
        justFormula.click();
    }
    public void setFormulaAndMenu(){
        formulaAndMenu.click();
    }
    public void setPriceInput(String price){
        priceInput.sendKeys(price);
    }
    public void setSelectCategory(String categoryName) {
        //selectCategory.click();

        selectCategory.click();
        try {
           // webDriver.findElement(By.xpath("//span[normalize-space()='" + categoryName + "']")).click();

        }catch (Exception e){
            selectCategory.click();
           // webDriver.findElement(By.xpath("//span[normalize-space()='" + categoryName + "']")).click();
        }
    }
    public void createNewProduct(){
        createProductButton.click();
    }
    public void saveProduct() { saveButton.click();}

    public ProductPage(WebDriver webDriver) {
        //super(webDriver);
    }

    public void verifyErrorMessage(String errorMsg) {
    }

    public void verifyPresentOfProduct(String productName) {
    }
}
